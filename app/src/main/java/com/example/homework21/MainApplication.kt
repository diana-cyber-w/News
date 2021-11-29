package com.example.homework21

import android.app.Application
import com.example.homework21.data.di.dataModule
import com.example.homework21.domain.di.domainModule
import com.example.homework21.presentation.di.sharedViewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(
                dataModule,
                domainModule,
                sharedViewModelsModule
            )
        }
    }
}