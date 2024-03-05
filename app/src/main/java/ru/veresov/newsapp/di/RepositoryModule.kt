package ru.veresov.newsapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.veresov.newsapp.data.repository.HeadlinesRepositoryImpl
import ru.veresov.newsapp.data.repository.NewsRepositoryImpl
import ru.veresov.newsapp.domain.repository.HeadlinesRepository
import ru.veresov.newsapp.domain.repository.NewsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideHeadlinesRepository(
        headlinesRepository: HeadlinesRepositoryImpl,
    ): HeadlinesRepository

    @Binds
    abstract fun provideNewsRepository(repository: NewsRepositoryImpl): NewsRepository

}