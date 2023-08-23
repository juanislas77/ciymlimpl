package com.islas.mockktesting

import android.app.Application
import com.islas.mockktesting.domain.di.modules.networkModule
import com.islas.mockktesting.domain.di.modules.repositoryModule
import com.islas.mockktesting.domain.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApp: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)

            modules(
                networkModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}
