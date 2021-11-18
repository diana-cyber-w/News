package com.example.homework21

import android.app.Application
import com.example.homework21.data.di.dataModule
import com.example.homework21.presentation.di.sharedViewModelsModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                dataModule,
                sharedViewModelsModule
            )
        }
    }
}