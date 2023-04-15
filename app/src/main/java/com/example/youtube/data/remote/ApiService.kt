package com.example.youtube.data.remote

import com.example.youtube.BuildConfig
import com.example.youtube.model.Playlist
import com.example.youtube.model.`object`.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlaylist(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("part") part: String = Constants.PART,
        @Query("channelId") channel: String = Constants.CHANNEL_ID,
        @Query("maxResults") maxResults : Int
    ) : Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("part") part: String = Constants.PART,
        @Query("channelId") channel: String = Constants.CHANNEL_ID,
        @Query("playlistId") playlistId: String
    ) : Response<Playlist>
}