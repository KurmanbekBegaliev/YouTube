package com.example.youtube

import android.app.Application
import com.example.youtube.di.dbModule
import com.example.youtube.di.networkModule
import com.example.youtube.di.repoModule
import com.example.youtube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repoModule, viewModelModule, dbModule))
        }
    }

}