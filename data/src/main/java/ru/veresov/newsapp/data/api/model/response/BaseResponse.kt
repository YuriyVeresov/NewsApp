package ru.veresov.newsapp.data.api.model.response

import com.squareup.moshi.Json

open class BaseResponse(
    @Json(name = "status") var status: String = "",
    @Json(name = "code") var code: String? = null,
    @Json(name = "message") var message: String? = null,
)