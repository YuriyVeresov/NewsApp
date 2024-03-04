package ru.veresov.newsapp.domain.repository

import ru.veresov.newsapp.domain.model.BlockSource
import ru.veresov.newsapp.domain.model.ResponseResult

interface NewsRepository {
    suspend fun loadNews(): ResponseResult<BlockSource>
}