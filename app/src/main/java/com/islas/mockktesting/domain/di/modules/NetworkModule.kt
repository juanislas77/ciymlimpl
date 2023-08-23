package com.islas.mockktesting.domain.di.modules

import com.islas.mockktesting.network.service.IService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module{
    singleOf(::provideApi)
}

fun provideBaseUrl() = "https://api.spacexdata.com/v5/"

fun provideApi(): IService {
    return Retrofit.Builder()
        .baseUrl(provideBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IService::class.java)
}
