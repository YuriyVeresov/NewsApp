package ru.veresov.newsapp.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.veresov.newsapp.data.NewsRepositoryImpl
import ru.veresov.newsapp.data.model.ResponseDataState
import ru.veresov.newsapp.domain.api.model.BlockSource
import ru.veresov.newsapp.domain.repository.NewsRepository
import javax.inject.Inject


@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {


    val mutableLiveData: LiveData<ResponseDataState<List<BlockSource>>> =
        (repository as NewsRepositoryImpl).newData

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.loadNews()
        }
    }

}