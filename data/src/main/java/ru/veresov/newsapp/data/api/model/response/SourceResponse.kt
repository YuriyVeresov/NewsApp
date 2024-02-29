package ru.veresov.newsapp.data.api.model.response

import com.squareup.moshi.Json
import ru.veresov.newsapp.data.api.model.SourceDto

data class SourceResponse(
    @Json(name = "sources") val sources: List<SourceDto>,
): BaseResponse()