package com.james.core.data

import com.james.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

@Suppress("EmptyMethod")
abstract class NetworkBoundResource<ResultType, RequestType> {

    private val resultData: Flow<ResultCustom<ResultType>> = flow {
        emit(ResultCustom.Loading())
        val databaseSource = loadFromDB().first()
        if (shouldFetch(databaseSource)) {
            emit(ResultCustom.Loading())
            when (val responseApi = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(responseApi.data)
                    emitAll(loadFromDB().map {
                        ResultCustom.Success(it)
                    })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map {
                        ResultCustom.Success(it)
                    })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(
                        ResultCustom.Error(responseApi.errorMessage)
                    )
                }
            }
        } else {
            emitAll(loadFromDB().map {
                ResultCustom.Success(it)
            })
        }
    }


    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<ResultCustom<ResultType>> = resultData

}