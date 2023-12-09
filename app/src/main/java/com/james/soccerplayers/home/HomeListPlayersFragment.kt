package com.james.soccerplayers.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.james.soccerplayers.R
import com.james.soccerplayers.detail.DetailPlayersActivity
import com.james.core.data.ResultCustom
import com.james.core.ui.ListSoccerPlayersAdapter
import com.james.soccerplayers.databinding.FragmentHomeListPlayersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeListPlayersFragment : Fragment() {
    private var _fragmentHomeListPlayersBinding: FragmentHomeListPlayersBinding? = null
    private val fragmentHomeListPlayersBinding get() = _fragmentHomeListPlayersBinding

    private val homeListPlayersViewModel: HomeListPlayersViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentHomeListPlayersBinding = FragmentHomeListPlayersBinding.inflate(inflater, container, false)
        return fragmentHomeListPlayersBinding?.root ?: inflater.inflate(R.layout.fragment_home_list_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val listSoccerPlayersAdapter = ListSoccerPlayersAdapter()
            listSoccerPlayersAdapter.onItemClickPlayer = {
                val intentToDetailPlayer = Intent(activity, DetailPlayersActivity::class.java)
                intentToDetailPlayer.putExtra(DetailPlayersActivity.EXTRA_DATA, it)
                startActivity(intentToDetailPlayer)
            }

            homeListPlayersViewModel.soccerPlayers.observe(viewLifecycleOwner) {
                if (it != null) {
                    when (it) {
                        is ResultCustom.Loading -> fragmentHomeListPlayersBinding?.pb?.visibility = View.VISIBLE
                        is ResultCustom.Success -> {
                            fragmentHomeListPlayersBinding?.pb?.visibility = View.GONE
                            listSoccerPlayersAdapter.submitList(it.dataResponse)
                        }
                        is ResultCustom.Error -> {
                            fragmentHomeListPlayersBinding?.pb?.visibility = View.GONE
                            fragmentHomeListPlayersBinding?.errorView?.root?.visibility = View.VISIBLE
                            fragmentHomeListPlayersBinding?.errorView?.errorTextView?.text =
                                it.msg ?: getString(R.string.message_wrong)
                        }
                    }
                }
            }

            val recyclerViewSoccerPlayers = view.findViewById<RecyclerView>(R.id.rv_soccer_players)
            with(recyclerViewSoccerPlayers) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = listSoccerPlayersAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentHomeListPlayersBinding = null
    }
}