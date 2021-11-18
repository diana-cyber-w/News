package com.example.homework21.data.di

import com.example.homework21.domain.NewsInteractor
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import com.example.homework21.data.DataSource

val DATA_SOURCE_QUALIFIER: Qualifier = qualifier("DATA_SOURCE_QUALIFIER")

val dataModule = module {
    single<NewsInteractor>(qualifier = DATA_SOURCE_QUALIFIER) {
        DataSource()
    }
}