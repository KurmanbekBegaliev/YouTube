package com.example.youtube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var etag: String? = null,
    var items: List<Item>? = null,
    var kind: String? = null,
    var nextPageToken: String? = null,
    var pageInfo: PageInfo? = null
)