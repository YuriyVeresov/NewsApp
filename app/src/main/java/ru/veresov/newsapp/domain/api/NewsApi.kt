package ru.veresov.newsapp.domain.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.veresov.newsapp.domain.api.model.request.Country
import ru.veresov.newsapp.domain.api.model.request.Language
import ru.veresov.newsapp.domain.api.model.response.SourceResponse

interface NewsApi {
    @GET("top-headlines/sources?")
    suspend fun loadSources(
        @Query("language") languages: Language = Language.EN,
        @Query("country") countries: Country = Country.US,
    ): Response<SourceResponse>
}