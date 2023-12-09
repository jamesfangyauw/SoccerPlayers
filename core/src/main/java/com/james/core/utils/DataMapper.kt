

package com.james.core.utils

import com.james.core.data.source.local.entity.SoccerPlayerEntity
import com.james.core.data.source.remote.response.SoccerPlayerResponse
import com.james.core.domain.model.SoccerPlayers

@Suppress("unused", "unused")
object DataMapper {

    fun mapResponseToEntity(inputList: List<SoccerPlayerResponse>): List<SoccerPlayerEntity> {
        val soccerPlayerList = ArrayList<SoccerPlayerEntity>()
        inputList.map {
            val soccerPlayer = SoccerPlayerEntity(
                idSoccerPlayer = it.idPlayer,
                namePlayer = it.namePlayer,
                soccerClubPlayer = it.soccerClub,
                ratePlayer = it.ratePlayer,
                positionPlayer = it.positionPlayer,
                goals = it.goals,
                assist = it.assists,
                activeSoccerPlayer = it.activeSoccerPlayer,
                descriptionPlayer = it.descPlayer,
                photoPlayer = it.imagePlayer,
                isFavoritePlayer = false
            )
            soccerPlayerList.add(soccerPlayer)
        }
        return soccerPlayerList
    }

    fun mapEntityToDomain(inputList: List<SoccerPlayerEntity>): List<SoccerPlayers> =
        inputList.map {
            SoccerPlayers(
                idSoccerPlayer = it.idSoccerPlayer,
                namePlayer = it.namePlayer,
                soccerClubPlayer = it.soccerClubPlayer,
                ratePlayer = it.ratePlayer,
                positionPlayer = it.positionPlayer,
                goals = it.goals,
                assist = it.assist,
                activeSoccerPlayer = it.activeSoccerPlayer,
                descriptionPlayer = it.descriptionPlayer,
                photoPlayer = it.photoPlayer,
                isFavoritePlayer = it.isFavoritePlayer
            )
        }

    fun mapDomainToEntity(inputSoccerPlayer: SoccerPlayers) = SoccerPlayerEntity(
        idSoccerPlayer = inputSoccerPlayer.idSoccerPlayer,
        namePlayer = inputSoccerPlayer.namePlayer,
        soccerClubPlayer = inputSoccerPlayer.soccerClubPlayer,
        ratePlayer = inputSoccerPlayer.ratePlayer,
        positionPlayer = inputSoccerPlayer.positionPlayer,
        goals = inputSoccerPlayer.goals,
        assist = inputSoccerPlayer.assist,
        activeSoccerPlayer = inputSoccerPlayer.activeSoccerPlayer,
        descriptionPlayer = inputSoccerPlayer.descriptionPlayer,
        photoPlayer = inputSoccerPlayer.photoPlayer,
        isFavoritePlayer = inputSoccerPlayer.isFavoritePlayer
    )
}