package ru.veresov.newsapp.domain.repository

import ru.veresov.newsapp.domain.model.Article
import ru.veresov.newsapp.domain.model.ResponseResult

interface HeadlinesRepository {
    suspend fun loadHeadLines(): ResponseResult<Article>

}