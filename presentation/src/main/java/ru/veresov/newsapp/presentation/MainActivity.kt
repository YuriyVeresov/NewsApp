package ru.veresov.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.veresov.newsapp.presentation.provider.ProvideViewModel
import ru.veresov.newsapp.presentation.screen.NewsScreen
import ru.veresov.newsapp.presentation.screen.NewsScreenViewModel
import ru.veresov.newsapp.presentation.theme.NewsAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val viewModel: NewsScreenViewModel =
            (application as ProvideViewModel).viewModel()

        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = NewsAppTheme.colorScheme.backgroundColor
                ) {
                    NewsScreen(viewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {

    }
}