package com.example.homework21.data.di

import com.example.homework21.domain.NewsInteractor
import org.koin.dsl.module
import com.example.homework21.data.DataSource

val dataModule = module {
    single<NewsInteractor>() {
        DataSource()
    }
}