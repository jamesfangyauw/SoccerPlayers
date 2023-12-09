package com.james.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused")
data class SoccerPlayerResponse(
    @field:SerializedName("id")
    val idPlayer: Int,
    @field:SerializedName("name")
    val namePlayer: String,
    @field:SerializedName("rate")
    val ratePlayer: String,
    @field:SerializedName("club")
    val soccerClub: String,
    @field:SerializedName("position")
    val positionPlayer: String,
    @field:SerializedName("allAssistUntilNow")
    val assists: Int,
    @field:SerializedName("allGoalUntilNow")
    val goals: Int,
    @field:SerializedName("description")
    val descPlayer: String,
    @field:SerializedName("activePlayer")
    val activeSoccerPlayer: String,
    @field:SerializedName("photo")
    val imagePlayer: String
)
