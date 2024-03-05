package ru.veresov.newsapp.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.veresov.newsapp.data.api.ApiDataFetch
import ru.veresov.newsapp.data.api.ApiResult
import ru.veresov.newsapp.data.api.NewsApi
import ru.veresov.newsapp.data.api.model.request.Country
import ru.veresov.newsapp.domain.model.Article
import ru.veresov.newsapp.domain.model.ResponseResult
import ru.veresov.newsapp.domain.repository.HeadlinesRepository
import java.util.Locale
import javax.inject.Inject

class HeadlinesRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val api: NewsApi,
) : ApiDataFetch(), HeadlinesRepository {

    override suspend fun loadHeadLines(): ResponseResult<Article> {

        val currentLocale: Locale =
            context.resources.configuration.locales.get(0)
        val countryCode = currentLocale.country
        val country = Country.entries.find { it.name == countryCode.uppercase() }


        when (val result = getResponse { api.loadHeadlines(country) }) {
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
                val newsBlocksDto = result.data.articles
                val newsBlocks = newsBlocksDto.map { it.toArticle() }
                return ResponseResult.Success(newsBlocks)
            }
        }
    }


}