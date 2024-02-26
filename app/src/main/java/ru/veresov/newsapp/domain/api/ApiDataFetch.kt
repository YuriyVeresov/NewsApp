package ru.veresov.newsapp.domain.api

import retrofit2.Response
import ru.veresov.newsapp.domain.api.model.response.BaseResponse

abstract class ApiDataFetch {
    protected suspend fun <T> getResponse(request: suspend () -> Response<T>): Result<T> {
        return try {
            val result = request.invoke()
            val error = result.getError()
            if (error == null) {
                Result.success(result.body()!!)
            } else {
                Result.failure(Throwable(error.second))
            }
        } catch (e: Throwable) {
            Result.failure(Throwable(e.localizedMessage))
        }
    }
}


fun <T> Response<T>.getError(): Pair<String?, String?>? {
    if (!this.isSuccessful) {
        return Pair(this.code().toString(), this.raw().message)
    }
    (body() as? BaseResponse)?.let {
        if (it.status != "ok") {
            return Pair(it.code, it.message)
        }
    }

    return null
}