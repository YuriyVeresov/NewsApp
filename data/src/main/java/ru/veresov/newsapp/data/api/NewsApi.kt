package ru.veresov.newsapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.veresov.newsapp.data.api.model.request.Country
import ru.veresov.newsapp.data.api.model.request.Language
import ru.veresov.newsapp.data.api.model.response.HeadlineResponse
import ru.veresov.newsapp.data.api.model.response.SourceResponse

interface NewsApi {
    @GET("top-headlines/sources")
    suspend fun loadSources(
        @Query("language") languages: Language = Language.EN,
        @Query("country") countries: Country = Country.US,
    ): Response<SourceResponse>


    @GET("top-headlines")
    suspend fun loadHeadlines(
        @Query("country") country: Country?,
    ): Response<HeadlineResponse>
}