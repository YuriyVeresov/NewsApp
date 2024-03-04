package ru.veresov.newsapp.data.api.model.request

import com.squareup.moshi.Json

enum class Language(val description: String) {
    @Json(name = "ar")
    AR("Arabic"),

    @Json(name = "de")
    DE("German"),

    @Json(name = "en")
    EN("English"),

    @Json(name = "es")
    ES("Spanish"),

    @Json(name = "fr")
    FR("French"),

    @Json(name = "he")
    HE("Hebrew"),

    @Json(name = "it")
    IT("Italian"),

    @Json(name = "nl")
    NL("Dutch"),

    @Json(name = "no")
    NO("Norwegian"),

    @Json(name = "pt")
    PT("Portuguese"),

    @Json(name = "ru")
    RU("Russian"),

    @Json(name = "sv")
    SV("Swedish"),

    @Json(name = "ud")
    UD("Undefined"),

    @Json(name = "zh")
    ZH("Chinese")
}