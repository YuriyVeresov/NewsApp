package ru.veresov.newsapp.data.api.model

import com.squareup.moshi.Json
import ru.veresov.newsapp.domain.model.ArticleSource

data class ArticleSourceDto(
    @Json(name = "id") val id: String?,
    @Json(name = "name") val name: String,
) {
    internal fun toArticleSource() = ArticleSource(id = id, name = name)
}