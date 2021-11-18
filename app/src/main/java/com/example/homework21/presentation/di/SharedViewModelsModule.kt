package com.example.homework21.presentation.di

import com.example.homework21.data.di.DATA_SOURCE_QUALIFIER
import com.example.homework21.presentation.FilterSharedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedViewModelsModule = module {

    viewModel {
        FilterSharedViewModel(
            interactor = get(qualifier = DATA_SOURCE_QUALIFIER)
        )
    }
}