package com.example.youtube.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.data.remote.Status
import com.example.youtube.databinding.FragmentDetailBinding
import com.example.youtube.model.custom.PlaylistItem
import com.example.youtube.utils.showToast

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    private lateinit var detailsAdapter: DetailsAdapter

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initViews() {
        val item = arguments?.getSerializable("item") as PlaylistItem
        binding.apply {
            tvPlaylistItemTitle.text = item.title.toString()
            tvPlaylistItemDescription.text = item.des.toString()
            tvPlaylistItemVideoCount.text = requireContext().getString(R.string.video_count, item.vCount.toString())
        }



        detailsAdapter = DetailsAdapter()
        binding.rvDetails.apply {
            this.adapter = detailsAdapter
            this.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    override fun initListeners() {
    }

    override fun initObservers() {
        val id = arguments?.getString("id")
        if (id != null) {
            viewModel.getPlaylistItems(id).observe(viewLifecycleOwner) {
                binding.progress.isVisible = it.status == Status.LOADING
                when (it.status) {
                    Status.SUCCESS -> detailsAdapter.addData(it.data?.items ?: emptyList())
                    Status.ERROR -> showToast(it.msg.toString())
                    else -> {}
                }

                Log.e("TAG", "initObservers: $it")
            }
        }
    }

}