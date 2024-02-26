package ru.veresov.newsapp.data.model

sealed class ResponseDataState<out T : Any> {
    data object Loading : ResponseDataState<Nothing>()
    class Error(val errorMessage: String?, val errorCode: String?) : ResponseDataState<Nothing>()
    class Success<out T : Any>(val data: T) : ResponseDataState<T>()
}