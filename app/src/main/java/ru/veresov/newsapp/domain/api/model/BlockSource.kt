package ru.veresov.newsapp.domain.api.model

data class BlockSource(
    val category: String,
    val news: List<Source>
)
