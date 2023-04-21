package com.example.youtube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.Repository
import com.example.youtube.data.remote.Resource
import com.example.youtube.model.Playlist

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    private val setPlaylistLiveData = MutableLiveData<Playlist>()
    private val getPlaylistLiveData = MutableLiveData<Boolean>()

    init {
        getPlaylistDb()
    }


    val playlist: LiveData<Resource<Playlist>> = repository.getPlaylist(5)

    val getPlaylistDb = getPlaylistLiveData.switchMap {
        repository.getPlaylistDb()
    }

//    val setPlaylistDb = setPlaylistLiveData.switchMap {
//        repository.setPlaylistDb(it)
//    }

    fun setPlaylistDb(playlist : Playlist) {
        setPlaylistLiveData.postValue(playlist)
    }

    fun getPlaylistDb() {
        getPlaylistLiveData.postValue(true)
    }

}