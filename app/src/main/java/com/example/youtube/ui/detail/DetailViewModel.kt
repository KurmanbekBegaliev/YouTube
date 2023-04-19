package com.example.youtube.ui.detail

import androidx.lifecycle.ViewModel
import com.example.youtube.data.Repository

class DetailViewModel : ViewModel() {

    private val repository = Repository()

    fun getPlaylistItems(id: String) = repository.getPlaylistItem(id)

}