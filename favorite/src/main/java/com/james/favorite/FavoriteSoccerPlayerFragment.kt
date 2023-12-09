package com.james.favorite

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.james.soccerplayers.detail.DetailPlayersActivity
import com.james.soccerplayers.detail.DetailPlayersActivity.Companion.EXTRA_DATA
import com.james.soccerplayers.di.FavoriteSoccerPlayerDependencies
import com.james.core.ui.ListSoccerPlayersAdapter
import com.james.favorite.viewmodel.FavoriteViewModelFactory
import com.google.android.material.textview.MaterialTextView
import com.james.favorite.databinding.FragmentFavoriteSoccerPlayerBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject
import com.james.favorite.di.DaggerFavoriteSoccerPlayerComponent

class FavoriteSoccerPlayerFragment : Fragment() {

    private var _fragmentFavoriteSoccerPlayerBinding: FragmentFavoriteSoccerPlayerBinding? = null
    private val fragmentFavoriteSoccerPlayerBinding get() = _fragmentFavoriteSoccerPlayerBinding

    @Inject
    lateinit var favoriteViewModelFactory: FavoriteViewModelFactory
    private val favoriteSoccerPlayerViewModel: FavoriteSoccerPlayerViewModel by viewModels {
        favoriteViewModelFactory
    }

    override fun onAttach(ctx: Context) {
        DaggerFavoriteSoccerPlayerComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoriteSoccerPlayerDependencies::class.java
                )
            ).build().inject(this)
        super.onAttach(ctx)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentFavoriteSoccerPlayerBinding = FragmentFavoriteSoccerPlayerBinding.inflate(inflater, container, false)
        return fragmentFavoriteSoccerPlayerBinding?.root ?: inflater.inflate(R.layout.fragment_favorite_soccer_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val listSoccerPlayersAdapter = ListSoccerPlayersAdapter()
            listSoccerPlayersAdapter.onItemClickPlayer = {
                val intentToDetailPlayer = Intent(activity, DetailPlayersActivity::class.java)
                intentToDetailPlayer.putExtra(EXTRA_DATA, it )
                startActivity(intentToDetailPlayer)
            }

            val emptyPlayer = view.findViewById<View>(R.id.tv_not_found_player)
            favoriteSoccerPlayerViewModel.favoriteSoccerPlayer.observe(viewLifecycleOwner) {
                listSoccerPlayersAdapter.submitList(it)
                emptyPlayer.visibility =
                    if (it.isNotEmpty()) View.GONE else View.VISIBLE
            }

            val rvFavoriteSoccerPlayer = view.findViewById<RecyclerView>(com.james.soccerplayers.R.id.rv_soccer_players)
            with(rvFavoriteSoccerPlayer) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = listSoccerPlayersAdapter
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFavoriteSoccerPlayerBinding = null
    }

}