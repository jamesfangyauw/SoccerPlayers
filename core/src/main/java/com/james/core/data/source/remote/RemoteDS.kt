package com.james.core.data.source.remote

import android.util.Log
import com.james.core.data.source.remote.network.ApiResponse
import com.james.core.data.source.remote.network.ApiService
import com.james.core.data.source.remote.response.SoccerPlayerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Suppress("unused", "unused")
class RemoteDS @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllListSoccerPlayer(): Flow<ApiResponse<List<SoccerPlayerResponse>>> {

        return flow {
            try {
                val soccerPlayerResponse = apiService.getAllSoccerPlayerList()
                val listData = soccerPlayerResponse.dataPlayer
                if (listData.isNotEmpty()) {
                    emit(ApiResponse.Success(soccerPlayerResponse.dataPlayer))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}