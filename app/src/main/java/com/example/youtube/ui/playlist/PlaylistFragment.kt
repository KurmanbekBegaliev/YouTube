package com.example.youtube.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.NetworkConnection
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.data.remote.Status
import com.example.youtube.databinding.FragmentPlaylistBinding
import com.example.youtube.model.custom.PlaylistItem
import com.example.youtube.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {
    override val viewModel: PlaylistViewModel by viewModel()

    private lateinit var playlistAdapter : PlaylistAdapter


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initViews() {
        playlistAdapter = PlaylistAdapter(requireContext(), this::onItemClick)
        binding.rvPlaylists.apply {
            adapter = playlistAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }

        binding.rvPlaylists.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {

                }
            }

        })
    }

    override fun initListeners() {

    }

    override fun initObservers() {
        val networkConnection = NetworkConnection(requireActivity())
        networkConnection.observe(viewLifecycleOwner) {
            if (it) makeRequest()
        }

        viewModel.getPlaylistDb.observe(viewLifecycleOwner){
            Log.e("TAG", "DataBase: ${it.data}" )
        }
    }

    private fun makeRequest() {
        viewModel.playlist.observe(viewLifecycleOwner){
            binding.progress.isVisible = it.status == Status.LOADING
            when(it.status) {
                Status.SUCCESS -> {
                    it.data?.let { it1 -> viewModel.setPlaylistDb(it1) }
                    playlistAdapter.addData(it.data?.items ?: emptyList())
                }
                Status.ERROR -> showToast(it.msg.toString())
                else -> {}
            }

        }
    }

    private fun onItemClick(id: String, item: PlaylistItem) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id, "item" to item))
    }

}