package com.james.core.domain.usecase

import com.james.core.data.ResultCustom
import com.james.core.domain.model.SoccerPlayers
import kotlinx.coroutines.flow.Flow

interface SoccerPlayersUseCase {

    fun getAllListSoccerPlayer(): Flow<ResultCustom<List<SoccerPlayers>>>

    fun getFavoriteSoccerPlayer(): Flow<List<SoccerPlayers>>

    fun setFavoriteSoccerPlayer(soccerPlayers: SoccerPlayers, stateNew: Boolean)
}