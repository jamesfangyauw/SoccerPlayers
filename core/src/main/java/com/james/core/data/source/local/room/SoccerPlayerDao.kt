package com.james.core.data.source.local.room

import androidx.room.*
import com.james.core.data.source.local.entity.SoccerPlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SoccerPlayerDao {

    @Query("SELECT * FROM soccer_player")
    fun getAllSoccerPlayer(): Flow<List<SoccerPlayerEntity>>

    @Query("SELECT * FROM soccer_player where isFavoritePlayer = 1")
    fun getFavoriteSoccerPlayer(): Flow<List<SoccerPlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSoccerPlayer(player: List<SoccerPlayerEntity>)

    @Update
    fun updateFavoriteSoccerPlayer(player: SoccerPlayerEntity)
}