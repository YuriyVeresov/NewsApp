package ru.veresov.newsapp.presentation.screen.state

sealed class ResponseDataState<T> {
    class Loading<T> : ResponseDataState<T>()
    data class Error<T>(val errorMessage: String?, val errorCode: String?) : ResponseDataState<T>()
    data class Success<T>(val blockNews: List<T>) : ResponseDataState<T>()
}