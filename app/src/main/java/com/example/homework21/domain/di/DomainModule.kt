package com.example.homework21.domain.di

import com.example.homework21.data.NewsInteractorImpl
import com.example.homework21.domain.NewsInteractor
import org.koin.dsl.module

val domainModule = module {
    single<NewsInteractor> {
        NewsInteractorImpl(newsDao = get())
    }
}