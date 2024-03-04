package ru.veresov.newsapp.data.api.model.request

import com.squareup.moshi.Json


enum class Category(val description: String) {
    @Json(name = "business")
    BUSINESS(description = "Business"),

    @Json(name = "entertainment")
    ENTERTAINMENT(description = "Entertainment"),

    @Json(name = "general")
    GENERAL(description = "General"),

    @Json(name = "health")
    HEALTH(description = "Health"),

    @Json(name = "science")
    SCIENCE(description = "Science"),

    @Json(name = "sports")
    SPORTS(description = "Sports"),

    @Json(name = "technology")
    TECHNOLOGY(description = "Technology")
}