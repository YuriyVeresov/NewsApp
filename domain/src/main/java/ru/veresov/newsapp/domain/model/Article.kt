package ru.veresov.newsapp.domain.model

data class Article(
    val source: ArticleSource,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
)