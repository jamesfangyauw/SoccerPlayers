package com.james.core.data.source.local

import com.james.core.data.source.local.entity.SoccerPlayerEntity
import com.james.core.data.source.local.room.SoccerPlayerDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Suppress("unused", "unused")
class LocalDS @Inject constructor(private val soccerPlayerDao: SoccerPlayerDao) {

    fun getAllSoccerPlayer(): Flow<List<SoccerPlayerEntity>> = soccerPlayerDao.getAllSoccerPlayer()

    fun getFavoriteSoccerPlayer(): Flow<List<SoccerPlayerEntity>> = soccerPlayerDao.getFavoriteSoccerPlayer()

    suspend fun insertSoccerPlayer(soccerPlayerList: List<SoccerPlayerEntity>) = soccerPlayerDao.insertSoccerPlayer(soccerPlayerList)

    fun setFavoriteSoccerPlayer(soccerPlayerEntity: SoccerPlayerEntity, stateNew: Boolean) {
        soccerPlayerEntity.isFavoritePlayer = stateNew
        soccerPlayerDao.updateFavoriteSoccerPlayer(soccerPlayerEntity)
    }
}