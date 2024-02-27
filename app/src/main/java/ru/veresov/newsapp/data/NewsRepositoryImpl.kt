package ru.veresov.newsapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.veresov.newsapp.data.model.ResponseDataState
import ru.veresov.newsapp.domain.api.NewsApi
import ru.veresov.newsapp.domain.api.ApiDataFetch
import ru.veresov.newsapp.domain.api.ApiResult
import ru.veresov.newsapp.domain.api.model.BlockSource
import ru.veresov.newsapp.domain.api.model.Source
import ru.veresov.newsapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val api: NewsApi,
) : ApiDataFetch(), NewsRepository {

    private val _newsData =
        MutableLiveData<ResponseDataState<List<BlockSource>>>()
    val newData: LiveData<ResponseDataState<List<BlockSource>>> get() = _newsData

    override suspend fun loadNews() {
        _newsData.postValue(ResponseDataState.Loading)

        when (val result = getResponse { api.loadSources() }) {
            is ApiResult.Error.ApiError -> {
                _newsData.postValue(ResponseDataState.Error(result.message, result.code))
            }

            is ApiResult.Error.NetworkError -> {
                _newsData.postValue(ResponseDataState.Error(result.message, result.code.toString()))
            }

            is ApiResult.Error.UnknownError -> {
                _newsData.postValue(ResponseDataState.Error(result.message, null))
            }

            is ApiResult.Success -> {
                groupSourcesByCategory(result.data.sources)
            }
        }

    }


    private fun groupSourcesByCategory(sources: List<Source>) {
        val groupedMap = sources.groupBy { it.category }
        val sortedKeys = groupedMap.keys.sorted()
        val result = mutableListOf<BlockSource>()
        for (category in sortedKeys) {
            val capitalizedCategory = category.replaceFirstChar { it.uppercaseChar() }
            result.add(BlockSource(capitalizedCategory, groupedMap[category] ?: emptyList()))
        }
        _newsData.value = ResponseDataState.Success(result)
    }


}
