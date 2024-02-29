package ru.veresov.newsapp.domain.model

sealed class ResultBlockSource {
    data class Error(val message: String?, val code: String?) : ResultBlockSource()
    data class Success(val newsBlocs: List<BlockSource>) : ResultBlockSource()
}
