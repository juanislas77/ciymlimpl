package com.islas.mockktesting.data.repository

import com.islas.mockktesting.domain.toDetail
import com.islas.mockktesting.domain.toDomain
import com.islas.mockktesting.domain.models.LaunchDetail
import com.islas.mockktesting.domain.models.LaunchDomain
import com.islas.mockktesting.domain.utils.ResultAPI
import com.islas.mockktesting.network.service.IService

class IServiceImpl(private val networkApi: IService): ServiceRepository {
    override suspend fun getData(): ResultAPI<List<LaunchDomain>> {
        return try{
            ResultAPI.Success(networkApi.getLaunchesData().body()?.map { it.toDomain() }?: emptyList())
        }
        catch (e: Exception){
            ResultAPI.Error(e.message.toString())
        }
    }

    override suspend fun getDetails(): ResultAPI<List<LaunchDetail>> {
        return try {
            ResultAPI.Success(networkApi.getLaunchesData().body()?.map { it.toDetail() }?: emptyList())
        }
        catch (e: java.lang.Exception){
            ResultAPI.Error(e.message.toString())
        }
    }
}
