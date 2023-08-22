package com.islas.mockktesting.network.service

import com.islas.mockktesting.data.LaunchesItemDTO
import retrofit2.Response
import retrofit2.http.GET

interface IService {
    @GET("launches")
    suspend fun getLaunchesData(): Response<List<LaunchesItemDTO>>
}
