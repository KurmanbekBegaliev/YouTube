package com.example.youtube.di

import com.example.youtube.data.Repository
import org.koin.dsl.module

val repoModule = module {
    single { Repository(get(), get()) }
}