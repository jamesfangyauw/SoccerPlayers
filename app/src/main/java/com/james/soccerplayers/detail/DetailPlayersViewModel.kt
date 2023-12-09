package com.james.soccerplayers.detail

import androidx.lifecycle.ViewModel
import com.james.core.domain.model.SoccerPlayers
import com.james.core.domain.usecase.SoccerPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPlayersViewModel @Inject constructor(private val soccerPlayersUseCase: SoccerPlayersUseCase) : ViewModel() {
    fun setFavoriteSoccerPlayer(soccerPlayers: SoccerPlayers, newSoccerPlayerStatus:Boolean) =
        soccerPlayersUseCase.setFavoriteSoccerPlayer(soccerPlayers, newSoccerPlayerStatus)
}