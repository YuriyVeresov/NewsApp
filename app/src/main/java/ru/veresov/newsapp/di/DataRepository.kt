package ru.veresov.newsapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.veresov.newsapp.data.api.NewsApi
import ru.veresov.newsapp.data.repository.HeadlinesRepositoryImpl
import ru.veresov.newsapp.domain.repository.HeadlinesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRepository {

    @Provides
    @Singleton
    fun provideHeadlinesRepository(
        api: NewsApi,
        @ApplicationContext context: Context,
    ): HeadlinesRepository {
        return HeadlinesRepositoryImpl(context, api)
    }

}