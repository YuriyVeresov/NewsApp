package ru.veresov.newsapp.domain.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import ru.veresov.newsapp.domain.api.model.response.BaseResponse

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    sealed class Error : ApiResult<Nothing>() {
        data class NetworkError(val code: Int, val message: String?) : Error()
        data class ApiError(val code: String?, val message: String?) : Error()
        data class UnknownError(val message: String?) : Error()
    }
}

abstract class ApiDataFetch {
    protected suspend fun <T> getResponse(request: suspend () -> Response<T>): ApiResult<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                result.body()?.let {
                    ApiResult.Success(it)
                } ?: ApiResult.Error.UnknownError("Response body is null")
            } else {
                result.getError()
            }
        } catch (e: Exception) {
            ApiResult.Error.UnknownError(e.localizedMessage)
        }
    }
}

private fun <T> Response<T>.getError(): ApiResult.Error {
    return if (isSuccessful) {
        (body() as? BaseResponse)?.let {
            if (it.status != "ok") {
                ApiResult.Error.ApiError(it.code, it.message)
            } else {
                ApiResult.Error.UnknownError("Unknown error occurred")
            }
        } ?: ApiResult.Error.UnknownError("Response body is empty")
    } else {
        val errorBody = this.errorBody()?.string()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<BaseResponse> = moshi.adapter(BaseResponse::class.java)

        val response = if (!errorBody.isNullOrEmpty()) {
            jsonAdapter.fromJson(errorBody)
        } else null
        ApiResult.Error.ApiError(response?.code, response?.message)
    }
}