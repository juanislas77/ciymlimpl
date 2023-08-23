package com.islas.mockktesting.domain.di.modules

import com.islas.mockktesting.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainViewModel)
//    singleOf(::MainViewModel)
}
