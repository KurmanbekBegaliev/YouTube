package com.example.youtube.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentVideoBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideoFragment : BaseFragment<FragmentVideoBinding, VideoViewModel>() {
    override val viewModel: VideoViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(inflater, container, false)
    }

    override fun initViews() {
        lifecycle.addObserver(binding.youtubePlayerView)

    }

    override fun initListeners() {
    }

    override fun initObservers() {
    }

}