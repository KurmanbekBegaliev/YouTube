package com.example.youtube.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.youtube.model.Playlist

@Dao
interface PlaylistDAO {

    @Insert(onConflict = REPLACE)
    suspend fun setPlaylist(playlist: Playlist)

    @Query("SELECT * FROM playlist")
    suspend fun getPlaylist(): Playlist
}