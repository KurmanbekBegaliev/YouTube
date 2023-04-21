package com.example.youtube.di

import android.content.Context
import androidx.room.Room
import com.example.youtube.data.local.AppDatabase
import org.koin.dsl.module

val dbModule = module {
    single { provideDB(get()) }
}

fun provideDB(applicationContext: Context) : AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "playlist"
    ).build()
}