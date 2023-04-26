package com.example.youtube.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentVideoBinding
import com.example.youtube.ui.BundleKeys
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import org.koin.androidx.viewmodel.ext.android.viewModel


class VideoFragment : BaseFragment<FragmentVideoBinding, VideoViewModel>() {
    override val viewModel: VideoViewModel by viewModel()

    private lateinit var youTubePlayerView: YouTubePlayerView
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(inflater, container, false)
    }

    override fun initViews() {
        youTubePlayerView = binding.youtubePlayerView
        val videoId = arguments?.getString(BundleKeys.DETAIL_TO_VIDEO_KEY, "").toString()
        lifecycle.addObserver(youTubePlayerView)
        val options = IFramePlayerOptions.Builder().controls(0).build()

        val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val defaultPlayerUiController =
                    DefaultPlayerUiController(youTubePlayerView, youTubePlayer)
                youTubePlayerView.setCustomPlayerUi(defaultPlayerUiController.rootView)
                youTubePlayer.loadVideo(videoId, 0F)
                youTubePlayer.play()
            }
        }

        binding.youtubePlayerView.initialize(listener, options)

    }

    override fun initListeners() {
    }

    override fun initObservers() {
    }

}