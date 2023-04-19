package com.example.youtube.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtube.App
import com.example.youtube.data.remote.Resource
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import kotlinx.coroutines.Dispatchers

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlaylistItem(id: String) : LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylistItems(playlistId = id)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun getPlaylist(maxResult : Int) : LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylist(maxResults = maxResult)
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
            } else {
            emit(Resource.error(result.message()))
        }
    }

    fun setPlaylistDb(playlist : Playlist) : LiveData<Resource<Boolean>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        App.db.dao().setPlaylist(playlist)
        emit(Resource.success(true))
    }

    fun getPlaylistDb(): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        emit(Resource.success(App.db.dao().getPlaylist()))
    }
}