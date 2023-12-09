package com.james.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.james.core.data.source.local.entity.SoccerPlayerEntity


@Database(entities = [SoccerPlayerEntity::class], version = 1, exportSchema = false)
abstract class SoccerPlayerDatabase : RoomDatabase() {

    abstract fun playerDao(): SoccerPlayerDao

}