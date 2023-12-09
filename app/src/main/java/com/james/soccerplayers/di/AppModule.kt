package com.james.soccerplayers.di

import com.james.core.data.SoccerPlayersRepository
import com.james.core.domain.usecase.SoccerPlayersInteractor
import com.james.core.domain.usecase.SoccerPlayersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSoccerPlayerUseCase(soccerPlayersRepository: SoccerPlayersRepository): SoccerPlayersUseCase=SoccerPlayersInteractor(soccerPlayersRepository)
}