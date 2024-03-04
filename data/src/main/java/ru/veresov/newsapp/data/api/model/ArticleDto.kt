package ru.veresov.newsapp.data.api.model

import com.squareup.moshi.Json
import ru.veresov.newsapp.domain.model.Article

data class ArticleDto(
    @Json(name = "source") val source: ArticleSourceDto,
    @Json(name = "author") val author: String?,
    @Json(name = "content") val content: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "publishedAt") val publishedAt: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "urlToImage") val urlToImage: String?,
) {
    internal fun toArticle() = Article(
        source = source.toArticleSource(),
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}