package ru.veresov.newsapp.domain.api.model.response

import com.squareup.moshi.Json
import ru.veresov.newsapp.domain.api.model.Source

data class SourceResponse(
    @Json(name = "sources") val sources: List<Source>,
): BaseResponse()