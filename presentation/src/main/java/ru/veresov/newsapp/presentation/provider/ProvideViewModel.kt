package ru.veresov.newsapp.presentation.provider

import ru.veresov.newsapp.presentation.screen.NewsScreenViewModel

interface ProvideViewModel {
    fun viewModel(): NewsScreenViewModel
}