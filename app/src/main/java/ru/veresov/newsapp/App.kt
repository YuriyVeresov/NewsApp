package ru.veresov.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.veresov.newsapp.presentation.provider.ProvideViewModel
import ru.veresov.newsapp.presentation.screen.HeadlinesScreenViewModel
import ru.veresov.newsapp.presentation.screen.NewsScreenViewModel
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), ProvideViewModel {
    @Inject
    lateinit var viewModel: NewsScreenViewModel

    @Inject
    lateinit var headlinesViewModel: HeadlinesScreenViewModel

    override fun viewModel(): NewsScreenViewModel {
        return viewModel
    }

    override fun headlinesViewModel(): HeadlinesScreenViewModel {
        return headlinesViewModel
    }

}