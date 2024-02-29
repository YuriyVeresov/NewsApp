package ru.veresov.newsapp.presentation.screen.state

import ru.veresov.newsapp.domain.model.BlockSource

sealed class ResponseDataState {
    data object Loading : ResponseDataState()
    data class Error(val errorMessage: String?, val errorCode: String?) : ResponseDataState()

    data class Success(val blockNews: List<BlockSource>) : ResponseDataState()
}