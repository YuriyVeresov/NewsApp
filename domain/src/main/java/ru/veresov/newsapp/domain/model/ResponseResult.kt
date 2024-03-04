package ru.veresov.newsapp.domain.model

sealed class ResponseResult<T> {
    data class Error<T>(val message: String?, val code: String?) : ResponseResult<T>()
    data class Success<T>(val result: List<T>) : ResponseResult<T>()
}
