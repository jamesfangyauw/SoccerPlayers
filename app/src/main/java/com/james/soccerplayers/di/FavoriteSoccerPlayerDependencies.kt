package com.james.soccerplayers.di

import com.james.core.domain.usecase.SoccerPlayersUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteSoccerPlayerDependencies {
    fun soccerPlayerUseCase(): SoccerPlayersUseCase
}