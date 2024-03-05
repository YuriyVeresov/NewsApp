package ru.veresov.newsapp.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.veresov.newsapp.BuildConfig
import ru.veresov.newsapp.data.api.NewsApi
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Singleton


private const val BASE_URL = "https://newsapi.org/v2/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun createRequestInterceptor() = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .build()


        val currentTime = Date()
        val sdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss a z", Locale.US)
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        val gtmDateString = sdf.format(currentTime)
        val apiKey = BuildConfig.API_KEY

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .addHeader("Date", gtmDateString)
            .addHeader("X-Api-Key", apiKey)

        chain.proceed(newRequest.build())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }
}