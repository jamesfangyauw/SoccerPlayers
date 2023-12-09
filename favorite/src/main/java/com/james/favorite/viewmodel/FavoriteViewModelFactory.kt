package com.james.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.james.core.domain.usecase.SoccerPlayersUseCase
import com.james.favorite.FavoriteSoccerPlayerViewModel
import javax.inject.Inject

class FavoriteViewModelFactory @Inject constructor(private val soccerPlayersUseCase: SoccerPlayersUseCase) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteSoccerPlayerViewModel::class.java)) {
            return FavoriteSoccerPlayerViewModel(soccerPlayersUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}