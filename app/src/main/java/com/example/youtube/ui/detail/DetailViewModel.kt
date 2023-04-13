package com.example.youtube.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.local.Repository
import com.example.youtube.data.remote.ApiService
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val repository = Repository()

    fun getPlaylistItems(id: String) = repository.getPlaylistItem(id)

}