package com.example.youtube.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.local.Repository
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val repository = Repository()

    val playlist: LiveData<Playlist> = repository.getPlaylist()

}