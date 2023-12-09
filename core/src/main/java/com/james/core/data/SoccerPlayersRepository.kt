package com.james.core.data

import com.james.core.data.source.local.LocalDS
import com.james.core.data.source.remote.RemoteDS
import com.james.core.data.source.remote.network.ApiResponse
import com.james.core.data.source.remote.response.SoccerPlayerResponse
import com.james.core.domain.model.SoccerPlayers
import com.james.core.domain.repository.ISoccerPlayersRepository
import com.james.core.utils.ApplicationExecutors
import com.james.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SoccerPlayersRepository @Inject constructor (
    private val remoteDS: RemoteDS,
    private val localDS: LocalDS,
    private val applicationExecutors: ApplicationExecutors
) : ISoccerPlayersRepository {

    override fun getAllListSoccerPlayer(): Flow<ResultCustom<List<SoccerPlayers>>> =
        object : NetworkBoundResource<List<SoccerPlayers>, List<SoccerPlayerResponse>>() {
            override fun loadFromDB(): Flow<List<SoccerPlayers>> {
                return localDS.getAllSoccerPlayer().map {
                    DataMapper.mapEntityToDomain(it)
                }
            }

            override fun shouldFetch(listData: List<SoccerPlayers>?): Boolean =
                listData == null || listData.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<SoccerPlayerResponse>>> =
                remoteDS.getAllListSoccerPlayer()

            override suspend fun saveCallResult(listData: List<SoccerPlayerResponse>) {
                val playerList = DataMapper.mapResponseToEntity(listData)
                localDS.insertSoccerPlayer(playerList)
            }
        }.asFlow()

    override fun getFavoriteSoccerPlayer(): Flow<List<SoccerPlayers>> {
        return localDS.getFavoriteSoccerPlayer().map { player ->
            DataMapper.mapEntityToDomain(player)
        }
    }

    override fun setFavoriteSoccerPlayer(soccerPlayers: SoccerPlayers, stateNew: Boolean) {
        val soccerPlayerEntity = DataMapper.mapDomainToEntity(soccerPlayers)
        applicationExecutors.diskIO().execute { localDS.setFavoriteSoccerPlayer(soccerPlayerEntity, stateNew) }
    }

}