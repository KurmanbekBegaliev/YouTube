package com.example.youtube.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.youtube.BuildConfig
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.base.BaseViewModel
import com.example.youtube.databinding.FragmentPlaylistBinding
import com.example.youtube.model.Item
import com.example.youtube.model.custom.PlaylistItem

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {
    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

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
    }

    override fun initListeners() {
    }

    override fun initObservers() {
        viewModel.playlist.observe(viewLifecycleOwner){
            playlistAdapter.addData(it.items ?: emptyList())
            Log.e("TAG", "initObservers: $it", )
        }
    }

    private fun onItemClick(id: String, item: PlaylistItem) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id, "item" to item))
    }

}