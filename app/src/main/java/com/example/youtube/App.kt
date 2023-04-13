package com.example.youtube

import android.app.Application
import com.example.youtube.data.local.Repository

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        repository = Repository()
    }

    companion object {
        lateinit var repository: Repository
    }
}