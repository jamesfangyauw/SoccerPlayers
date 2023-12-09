package com.james.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.james.core.R
import com.james.core.databinding.ItemSoccerPlayerBinding

import com.james.core.domain.model.SoccerPlayers

@Suppress("unused", "unused")
class ListSoccerPlayersAdapter : ListAdapter<SoccerPlayers, ListSoccerPlayersAdapter.ListViewHolder>(SoccerPlayerDiffCallback) {

    var onItemClickPlayer: ((SoccerPlayers) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_soccer_player, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dataPlayer = getItem(position)
        holder.bind(dataPlayer)
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemSoccerPlayerBinding = ItemSoccerPlayerBinding.bind(view)
        fun bind(dataPlayer: SoccerPlayers) {
            with(itemSoccerPlayerBinding) {
                Glide.with(itemView.context)
                    .load(dataPlayer.photoPlayer)
                    .into(imageItemPhotoPlayer)
                tvItemNamePlayer.text = dataPlayer.namePlayer
                tvItemClubPlayer.text = dataPlayer.soccerClubPlayer
            }
        }

        init {
            itemSoccerPlayerBinding.root.setOnClickListener {
                onItemClickPlayer?.invoke(getItem(adapterPosition))
            }
        }
    }

    companion object SoccerPlayerDiffCallback : DiffUtil.ItemCallback<SoccerPlayers>() {
        override fun areItemsTheSame(oldItem: SoccerPlayers, newItem: SoccerPlayers): Boolean {
            return oldItem.idSoccerPlayer == newItem.idSoccerPlayer
        }

        override fun areContentsTheSame(oldItem: SoccerPlayers, newItem: SoccerPlayers): Boolean {
            return oldItem == newItem
        }
    }
}
