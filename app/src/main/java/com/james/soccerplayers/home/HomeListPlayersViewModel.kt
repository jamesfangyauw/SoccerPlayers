package com.james.soccerplayers.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.james.core.domain.usecase.SoccerPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeListPlayersViewModel @Inject constructor(soccerPlayersUseCase: SoccerPlayersUseCase): ViewModel() {
    val soccerPlayers = soccerPlayersUseCase.getAllListSoccerPlayer().asLiveData()

}