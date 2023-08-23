package com.islas.mockktesting.domain.di.modules

import com.islas.mockktesting.data.repository.IServiceImpl
import com.islas.mockktesting.data.repository.ServiceRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module{
    singleOf(::IServiceImpl) {
        bind<ServiceRepository>()
    }
}

//    fun provideRepository(api: IService): ServiceRepository{
//        return IServiceImpl(api)
//    }
