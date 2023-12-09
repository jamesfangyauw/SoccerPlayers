package com.james.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused")
data class ListSoccerPlayerResponse(

    @field:SerializedName("error")
    val errorState: Boolean,

    @field:SerializedName("data")
    val dataPlayer: List<SoccerPlayerResponse>,

    @field:SerializedName("message")
    val msg: String,
)
