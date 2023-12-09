package com.james.core.domain.repository

import com.james.core.data.ResultCustom
import com.james.core.domain.model.SoccerPlayers
import kotlinx.coroutines.flow.Flow

@Suppress("unused", "unused")
interface ISoccerPlayersRepository {

    fun getAllListSoccerPlayer(): Flow<ResultCustom<List<SoccerPlayers>>>

    fun getFavoriteSoccerPlayer(): Flow<List<SoccerPlayers>>

    fun setFavoriteSoccerPlayer(soccerPlayers: SoccerPlayers, stateNew: Boolean)

}