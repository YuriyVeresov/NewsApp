package ru.veresov.newsapp.data.api.model

import ru.veresov.newsapp.domain.model.BlockSource

data class BlockSourceDto(
    val category: String,
    val news: List<SourceDto>,
) {
    fun toBlockSource(): BlockSource {
        val news = this.news.map { sourceDto -> sourceDto.toSource() }
        return BlockSource(category, news)
    }
}
