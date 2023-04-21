package com.example.youtube.ui.detail

import androidx.lifecycle.ViewModel
import com.example.youtube.data.Repository

class DetailViewModel(private val repository: Repository) : ViewModel() {

    fun getPlaylistItems(id: String) = repository.getPlaylistItem(id)

}