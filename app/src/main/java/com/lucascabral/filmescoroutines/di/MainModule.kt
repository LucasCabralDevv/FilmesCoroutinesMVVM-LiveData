package com.lucascabral.filmescoroutines.di

import com.lucascabral.filmescoroutines.ui.main.MainRepository
import com.lucascabral.filmescoroutines.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    factory {
        MainRepository()
    }

    viewModel {
        MainViewModel(
            repository = get()
        )
    }
}