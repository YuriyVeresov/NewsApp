package ru.veresov.newsapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.veresov.newsapp.R
import ru.veresov.newsapp.presentation.component.ErrorAlertDialog
import ru.veresov.newsapp.presentation.component.HeadlinesItem
import ru.veresov.newsapp.presentation.provider.ProvideViewModel
import ru.veresov.newsapp.presentation.screen.state.ResponseDataState

@Composable
fun HeadlinesScreen() {

    val viewModel: HeadlinesScreenViewModel =
        (LocalContext.current.applicationContext as ProvideViewModel).headlinesViewModel()

    val screenState = viewModel.externalResponseData.observeAsState()

    screenState.value?.let { responseState ->

        when (responseState) {
            is ResponseDataState.Error -> {
                ErrorAlertDialog(
                    onDismissRequest = { },
                    onConfirmation = { viewModel.loadHeadlines() },
                    errorCode = responseState.errorCode
                        ?: stringResource(id = R.string.unknown_code),
                    errorMessage = responseState.errorMessage
                        ?: stringResource(id = R.string.unknown_error),
                )
            }

            is ResponseDataState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(48.dp))
                }
            }

            is ResponseDataState.Success -> {
                LazyColumn(content = {
                    items(responseState.blockNews) { article ->
                        HeadlinesItem(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                                .height(200.dp),
                            article = article
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                })
            }
        }
    }

}


@Composable
@Preview
private fun HeadlinesScreenPreview() {
    HeadlinesScreen()
}