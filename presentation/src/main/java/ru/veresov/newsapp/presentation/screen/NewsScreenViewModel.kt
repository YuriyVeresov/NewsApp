package ru.veresov.newsapp.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.veresov.newsapp.domain.model.BlockSource
import ru.veresov.newsapp.domain.model.ResponseResult
import ru.veresov.newsapp.domain.repository.NewsRepository
import ru.veresov.newsapp.presentation.screen.state.ResponseDataState
import javax.inject.Inject


class NewsScreenViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {

    private val _internalResponseData = MutableLiveData<ResponseDataState<BlockSource>>()
    val externalResponseData: LiveData<ResponseDataState<BlockSource>> get() = _internalResponseData

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {

            _internalResponseData.postValue(ResponseDataState.Loading())
            when (val resultBlockSource = repository.loadNews()) {
                is ResponseResult.Error -> {
                    _internalResponseData.postValue(
                        ResponseDataState.Error(
                            resultBlockSource.message,
                            resultBlockSource.code
                        )
                    )
                }

                is ResponseResult.Success -> {
                    _internalResponseData.postValue(ResponseDataState.Success(resultBlockSource.result))
                }
            }
        }
    }

}