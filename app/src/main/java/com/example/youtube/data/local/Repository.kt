package com.example.youtube.data.local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlaylistItem(id: String) : LiveData<Playlist> {
        val playlistItems = MutableLiveData<Playlist>()
        apiService.getPlaylistItems(playlistId = id).enqueue(
            object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    playlistItems.value = response.body()
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}", )
                }

            })
        return playlistItems
    }

    fun getPlaylist() : LiveData<Playlist> {
        val playlistLiveData = MutableLiveData<Playlist>()
        apiService.getPlaylist().enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                Log.e("TAG", "onResponse: ", )
                if (response.isSuccessful) {
                    Log.e("TAG", "onResponse: ${response.body()}", )
                    playlistLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message}")
            }

        })
        return playlistLiveData
    }
}