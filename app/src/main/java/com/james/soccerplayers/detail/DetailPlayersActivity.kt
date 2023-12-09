package com.james.soccerplayers.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.james.soccerplayers.R
import com.james.soccerplayers.databinding.ActivityDetailPlayersBinding
import com.james.core.domain.model.SoccerPlayers
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("unused", "unused")
class DetailPlayersActivity : AppCompatActivity() {

    private val detailPlayersViewModel: DetailPlayersViewModel by viewModels()
    private lateinit var activityDetailPlayersBinding: ActivityDetailPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailPlayersBinding = ActivityDetailPlayersBinding.inflate(layoutInflater)
        setContentView(activityDetailPlayersBinding.root)


        val btnBack = activityDetailPlayersBinding.btnBack
        btnBack.setOnClickListener {
            onBackPressed()
        }

        val detailSoccerPlayers = intent.getParcelableExtra<SoccerPlayers>(EXTRA_DATA)
        detailSoccerPlayersShow(detailSoccerPlayers)

    }

    private fun detailSoccerPlayersShow(detailSoccerPlayers: SoccerPlayers?) {
        detailSoccerPlayers?.let {
            activityDetailPlayersBinding.nameSoccerPlayerDetail.text = detailSoccerPlayers.namePlayer
            Glide.with(this@DetailPlayersActivity)
                .load(detailSoccerPlayers.photoPlayer)
                .into(activityDetailPlayersBinding.photoSoccerPlayerDetail)

            activityDetailPlayersBinding.rateSoccerPlayerDetail.text = detailSoccerPlayers.ratePlayer

            var statusSoccerPlayerFavorite = detailSoccerPlayers.isFavoritePlayer
            setStatusSoccerPlayerFavorite(statusSoccerPlayerFavorite)
            activityDetailPlayersBinding.favoriteSoccerPlayerDetail.setOnClickListener {
                statusSoccerPlayerFavorite = !statusSoccerPlayerFavorite
                detailPlayersViewModel.setFavoriteSoccerPlayer(detailSoccerPlayers, statusSoccerPlayerFavorite)
                setStatusSoccerPlayerFavorite(statusSoccerPlayerFavorite)
            }

            activityDetailPlayersBinding.tvSoccerPlayersClubValue.text = detailSoccerPlayers.soccerClubPlayer
            activityDetailPlayersBinding.tvSoccerPlayersPositionValue.text = detailSoccerPlayers.positionPlayer
            activityDetailPlayersBinding.tvSoccerPlayersTotalGoalsValue.text = detailSoccerPlayers.goals.toString()
            activityDetailPlayersBinding.tvSoccerPlayersTotalAssistValue.text = detailSoccerPlayers.assist.toString()
            activityDetailPlayersBinding.tvSoccerActivePlayerValue.text = detailSoccerPlayers.activeSoccerPlayer
            activityDetailPlayersBinding.tvSoccerPlayersDescriptionValue.text = detailSoccerPlayers.descriptionPlayer
        }
    }

    private fun setStatusSoccerPlayerFavorite(statusSoccerPlayerFavorite: Boolean) {
        if (statusSoccerPlayerFavorite) {
            activityDetailPlayersBinding.favoriteSoccerPlayerDetail.setImageResource(R.drawable.baseline_favorite_24)
        } else {
            activityDetailPlayersBinding.favoriteSoccerPlayerDetail.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

}