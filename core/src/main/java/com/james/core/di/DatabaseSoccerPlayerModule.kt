package com.james.core.di

import android.content.Context
import androidx.room.Room
import com.james.core.data.source.local.room.SoccerPlayerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseSoccerPlayerModule {

    @Singleton
    @Provides
    fun provideDatabaseSoccerPlayer(@ApplicationContext ctx: Context): SoccerPlayerDatabase {
        val bytePassphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val supportFactory = net.sqlcipher.database.SupportFactory(bytePassphrase)
        return Room.databaseBuilder(
            ctx,
            SoccerPlayerDatabase::class.java, "SoccerPlayerData.db"
        ).fallbackToDestructiveMigration().openHelperFactory(supportFactory).build()
    }

    @Provides
    fun provideSoccerPlayerDao(soccerPlayerDatabase: SoccerPlayerDatabase) = soccerPlayerDatabase.playerDao()
}