package com.james.core.data

@Suppress("unused", "unused")
sealed class ResultCustom <T>(val dataResponse: T? = null, val msg: String? = null){
    class Success<T>(dataResponse: T) : ResultCustom<T>(dataResponse)
    class Error<T>(msg: String, dataResponse: T? = null) : ResultCustom<T>(dataResponse, msg)
    class Loading<T>(dataResponse: T? = null) : ResultCustom<T>(dataResponse)
}

