package ru.veresov.newsapp.data.repository

import ru.veresov.newsapp.data.api.ApiDataFetch
import ru.veresov.newsapp.data.api.ApiResult
import ru.veresov.newsapp.data.api.NewsApi
import ru.veresov.newsapp.data.api.model.BlockSourceDto
import ru.veresov.newsapp.data.api.model.SourceDto
import ru.veresov.newsapp.domain.model.BlockSource
import ru.veresov.newsapp.domain.model.ResponseResult
import ru.veresov.newsapp.domain.repository.NewsRepository


class NewsRepositoryImpl(
    private val api: NewsApi,
) : ApiDataFetch(), NewsRepository {

    override suspend fun loadNews(): ResponseResult<BlockSource> {

        when (val result = getResponse { api.loadSources() }) {
            is ApiResult.Error.ApiError -> {
                return ResponseResult.Error(result.message, result.code)
            }

            is ApiResult.Error.NetworkError -> {
                return ResponseResult.Error(result.message, result.code.toString())
            }

            is ApiResult.Error.UnknownError -> {
                return ResponseResult.Error(result.message, null)
            }

            is ApiResult.Success -> {
                val newsBlocksDto = groupSourcesByCategory(result.data.sources)
                val newsBlocks = newsBlocksDto.map { it.toBlockSource() }
                return ResponseResult.Success(newsBlocks)
            }
        }

    }


    private fun groupSourcesByCategory(sources: List<SourceDto>): List<BlockSourceDto> {
        val groupedMap = sources.groupBy { it.category }
        val sortedKeys = groupedMap.keys.sorted()
        val result = mutableListOf<BlockSourceDto>()
        for (category in sortedKeys) {
            val capitalizedCategory = category.replaceFirstChar { it.uppercaseChar() }
            result.add(BlockSourceDto(capitalizedCategory, groupedMap[category] ?: emptyList()))
        }
        return result.toList()
    }


}
