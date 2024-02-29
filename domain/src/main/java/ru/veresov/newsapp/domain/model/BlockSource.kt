package ru.veresov.newsapp.domain.model

data class BlockSource(
    val category: String,
    val news: List<Source>,
)
