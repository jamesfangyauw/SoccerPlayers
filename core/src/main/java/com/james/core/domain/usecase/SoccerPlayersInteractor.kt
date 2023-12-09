package com.james.core.domain.usecase

import com.james.core.domain.model.SoccerPlayers
import com.james.core.domain.repository.ISoccerPlayersRepository
import javax.inject.Inject

class SoccerPlayersInteractor @Inject constructor (private val soccerPlayerRepository: ISoccerPlayersRepository) : SoccerPlayersUseCase {

    override fun getAllListSoccerPlayer() = soccerPlayerRepository.getAllListSoccerPlayer()

    override fun getFavoriteSoccerPlayer() = soccerPlayerRepository.getFavoriteSoccerPlayer()

    override fun setFavoriteSoccerPlayer(soccerPlayers: SoccerPlayers, stateNew: Boolean) = soccerPlayerRepository.setFavoriteSoccerPlayer(soccerPlayers, stateNew)
}