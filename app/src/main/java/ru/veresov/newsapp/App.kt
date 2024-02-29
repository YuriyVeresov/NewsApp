package ru.veresov.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.veresov.newsapp.presentation.provider.ProvideViewModel
import ru.veresov.newsapp.presentation.screen.NewsScreenViewModel
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), ProvideViewModel {
    @Inject
    lateinit var viewModel: NewsScreenViewModel
    override fun viewModel(): NewsScreenViewModel {
        return viewModel
    }

}