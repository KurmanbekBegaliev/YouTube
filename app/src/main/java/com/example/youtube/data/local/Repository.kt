package com.example.youtube.data.local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlaylistItem(id: String) : LiveData<Playlist> = liveData(Dispatchers.IO) {
        val result = apiService.getPlaylistItems(playlistId = id)
        if (result.isSuccessful) {
            result.body()?.let { emit(it) }
        } else {
            Log.e("TAG", "getPlaylist: ${result.message()}", )
        }
    }

    fun getPlaylist(maxResult : Int) : LiveData<Playlist> = liveData(Dispatchers.IO) {
        val result = apiService.getPlaylist(maxResults = maxResult)
        if (result.isSuccessful) {
            result.body()?.let { emit(it) }
            } else {
            Log.e("TAG", "getPlaylist: ${result.message()}", )
        }
    }
}