package com.james.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SoccerPlayers(
    var idSoccerPlayer: Int,
    var namePlayer: String,
    var soccerClubPlayer: String,
    var ratePlayer: String,
    var positionPlayer: String,
    var goals: Int,
    var assist: Int,
    var activeSoccerPlayer: String,
    var descriptionPlayer: String,
    var photoPlayer: String,
    var isFavoritePlayer: Boolean = false
) : Parcelable
