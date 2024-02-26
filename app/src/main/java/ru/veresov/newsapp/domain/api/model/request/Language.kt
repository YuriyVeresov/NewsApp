package ru.veresov.newsapp.domain.api.model.request

import com.squareup.moshi.Json

enum class Language {
    @Json(name = "ar")
    AR,

    @Json(name = "de")
    DE,

    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "fr")
    FR,

    @Json(name = "he")
    HE,

    @Json(name = "it")
    IT,

    @Json(name = "nl")
    NL,

    @Json(name = "no")
    NO,

    @Json(name = "pt")
    PT,

    @Json(name = "ru")
    RU,

    @Json(name = "sv")
    SV,

    @Json(name = "ud")
    UD,

    @Json(name = "zh")
    ZH,
}