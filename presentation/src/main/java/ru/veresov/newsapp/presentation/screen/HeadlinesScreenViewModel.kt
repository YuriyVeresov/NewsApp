package ru.veresov.newsapp.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.veresov.newsapp.domain.model.Article
import ru.veresov.newsapp.domain.model.ResponseResult
import ru.veresov.newsapp.domain.repository.HeadlinesRepository
import ru.veresov.newsapp.presentation.screen.state.ResponseDataState
import javax.inject.Inject


class HeadlinesScreenViewModel @Inject constructor(
    private val headlinesRepository: HeadlinesRepository,
) : ViewModel() {

    private val _internalResponseData = MutableLiveData<ResponseDataState<Article>>()
    val externalResponseData: LiveData<ResponseDataState<Article>> get() = _internalResponseData


    init {
        loadHeadlines()
    }

    fun loadHeadlines() {
        _internalResponseData.postValue(ResponseDataState.Loading())
        viewModelScope.launch {
            when (val response = headlinesRepository.loadHeadLines()) {
                is ResponseResult.Error -> {
                    _internalResponseData.postValue(
                        ResponseDataState.Error(
                            response.message,
                            response.code
                        )
                    )
                }

                is ResponseResult.Success -> {
                    _internalResponseData.postValue(ResponseDataState.Success(blockNews = response.result))
                }
            }
        }
    }
}