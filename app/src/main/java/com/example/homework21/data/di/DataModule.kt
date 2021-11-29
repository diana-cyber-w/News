package com.example.homework21.data.di

import androidx.room.Room
import com.example.homework21.data.storage.AppDatabase
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "news"
        ).build()
    }

    single {
        get<AppDatabase>().getNewsDao()
    }
}