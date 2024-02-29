package ru.veresov.newsapp.data.api.model

import com.squareup.moshi.Json
import ru.veresov.newsapp.domain.model.Source

data class SourceDto(
    @Json(name = "category") val category: String,
    @Json(name = "country") val country: String,
    @Json(name = "description") val description: String,
    @Json(name = "id") val id: String,
    @Json(name = "language") val language: String,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
) {
    fun toSource() = Source(category, country, description, id, language, name, url)
}