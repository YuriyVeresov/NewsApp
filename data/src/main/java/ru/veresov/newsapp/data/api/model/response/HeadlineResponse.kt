package ru.veresov.newsapp.data.api.model.response

import com.squareup.moshi.Json
import ru.veresov.newsapp.data.api.model.ArticleDto

data class HeadlineResponse(
    @Json(name = "totalResults") val totalResult: Int,
    @Json(name = "articles") val articles: List<ArticleDto>,
) : BaseResponse()

