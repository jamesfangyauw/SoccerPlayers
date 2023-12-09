package com.james.core.data.source.remote.network

import com.james.core.data.source.remote.response.ListSoccerPlayerResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/players")
    suspend fun getAllSoccerPlayerList(): ListSoccerPlayerResponse
}