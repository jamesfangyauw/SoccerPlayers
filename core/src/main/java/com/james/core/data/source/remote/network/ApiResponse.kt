@file:Suppress("unused", "unused")

package com.james.core.data.source.remote.network

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused")
sealed class ApiResponse<out R> {

    data class Success<out T>(val data: T) : ApiResponse<T>()

    object Empty : ApiResponse<Nothing>()

    data class Error(val errorMessage: String) : ApiResponse<Nothing>()

}