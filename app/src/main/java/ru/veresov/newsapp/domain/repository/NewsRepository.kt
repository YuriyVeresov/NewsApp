package ru.veresov.newsapp.domain.repository

interface NewsRepository {
    suspend fun loadNews()
}