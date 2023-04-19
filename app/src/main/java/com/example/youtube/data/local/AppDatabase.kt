package com.example.youtube.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.youtube.model.Playlist

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao() : PlaylistDAO
}