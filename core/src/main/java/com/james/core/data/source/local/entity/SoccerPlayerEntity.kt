package com.james.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soccer_player")
@Suppress("unused", "unused")
data class SoccerPlayerEntity(
    @PrimaryKey
    @ColumnInfo(name = "idSoccerPlayer")
    var idSoccerPlayer: Int,

    @ColumnInfo(name = "namePlayer")
    var namePlayer: String,

    @ColumnInfo(name = "soccerClubPlayer")
    var soccerClubPlayer: String,

    @ColumnInfo(name = "ratePlayer")
    var ratePlayer: String,

    @ColumnInfo(name = "positionPlayer")
    var positionPlayer: String,

    @ColumnInfo(name = "goals")
    var goals: Int,

    @ColumnInfo(name = "assist")
    var assist: Int,

    @ColumnInfo(name = "activeSoccerPlayer")
    var activeSoccerPlayer: String,

    @ColumnInfo(name = "descriptionPlayer")
    var descriptionPlayer: String,

    @ColumnInfo(name = "photoPlayer")
    var photoPlayer: String,

    @ColumnInfo(name = "isFavoritePlayer")
    var isFavoritePlayer: Boolean = false
)
