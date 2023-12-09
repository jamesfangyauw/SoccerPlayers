package com.james.core.di

import com.james.core.data.SoccerPlayersRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.james.core.domain.repository.ISoccerPlayersRepository
import dagger.Binds


@Module(includes = [NetworkApiModule::class, DatabaseSoccerPlayerModule::class])
@InstallIn(SingletonComponent::class)
@Suppress("unused", "unused")
abstract class RepositorySoccerPlayerModule {
    @Binds
    abstract fun provideSoccerPlayerRepository(soccerPlayersRepository: SoccerPlayersRepository): ISoccerPlayersRepository

}