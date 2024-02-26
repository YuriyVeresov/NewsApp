package ru.veresov.newsapp.presentation.screen


import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.veresov.newsapp.data.model.ResponseDataState
import ru.veresov.newsapp.presentation.component.NewsBlock

@Composable
fun NewsScreen() {
    val viewModel: NewsScreenViewModel = hiltViewModel()
    val state = viewModel.mutableLiveData.observeAsState()

    state.value?.let { responseState ->

        when (responseState) {
            is ResponseDataState.Error -> {
                Toast.makeText(LocalContext.current, responseState.errorMessage, Toast.LENGTH_SHORT)
                    .show()
            }

            ResponseDataState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(48.dp))
                }
            }

            is ResponseDataState.Success -> {
                LazyColumn(content = {
                    items(responseState.data) { news ->
                        NewsBlock(blockNews = news)
                    }
                })
            }
        }
    }

}

@Composable
@Preview
fun NewsScreenPreview() {
    NewsScreen()
}