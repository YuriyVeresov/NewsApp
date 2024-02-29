package ru.veresov.newsapp.domain.repository

import ru.veresov.newsapp.domain.model.ResultBlockSource

interface NewsRepository {
    suspend fun loadNews(): ResultBlockSource
}