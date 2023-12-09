package com.james.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.james.core.domain.usecase.SoccerPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteSoccerPlayerViewModel @Inject constructor(soccerPlayersUseCase: SoccerPlayersUseCase) : ViewModel() {
    val favoriteSoccerPlayer = soccerPlayersUseCase.getFavoriteSoccerPlayer().asLiveData()
}