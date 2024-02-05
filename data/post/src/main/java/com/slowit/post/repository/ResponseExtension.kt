package com.slowit.post.repository

import okhttp3.ResponseBody
import retrofit2.Response

inline fun <T> Response<T>.onSuccess(action: (httpCode: Int, value: T?) -> Unit): Response<T> {
    if (isSuccessful) {
        action(code(), body())
    }
    return this
}

inline fun <T> Response<T>.onError(action: (httpCode: Int, errorBody: ResponseBody?) -> Unit): Response<T> {
    if (!isSuccessful) {
        action(code(), errorBody())
    }
    return this
}
