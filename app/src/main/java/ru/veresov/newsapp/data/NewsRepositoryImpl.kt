package ru.veresov.newsapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.veresov.newsapp.domain.api.NewsApi
import ru.veresov.newsapp.domain.api.ApiDataFetch
import ru.veresov.newsapp.domain.api.model.BlockSource
import ru.veresov.newsapp.domain.api.model.Source
import ru.veresov.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
) : ApiDataFetch(), NewsRepository {


    private val _newsData =
        MutableLiveData<ru.veresov.newsapp.data.model.ResponseDataState<List<BlockSource>>>()
    val newData: LiveData<ru.veresov.newsapp.data.model.ResponseDataState<List<BlockSource>>> get() = _newsData

    override suspend fun loadNews() {
        _newsData.postValue(ru.veresov.newsapp.data.model.ResponseDataState.Loading)
        val result = getResponse { api.loadSources() }

        if (result.isSuccess) {
            val response = result.getOrThrow()
            try {
                val news = response.sources
                groupSourcesByCategory(sources = news)
            } catch (t: Throwable) {
                _newsData.postValue(
                    ru.veresov.newsapp.data.model.ResponseDataState.Error(
                        response.message,
                        response.code
                    )
                )
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

        _newsData.value = ru.veresov.newsapp.data.model.ResponseDataState.Success(result)
    }


}
