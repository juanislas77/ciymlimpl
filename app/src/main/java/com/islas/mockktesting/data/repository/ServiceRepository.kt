package com.islas.mockktesting.data.repository

import com.islas.mockktesting.domain.models.LaunchDetail
import com.islas.mockktesting.domain.models.LaunchDomain
import com.islas.mockktesting.domain.utils.ResultAPI

interface ServiceRepository {
    suspend fun getData(): ResultAPI<List<LaunchDomain>>

    suspend fun getDetails(): ResultAPI<List<LaunchDetail>>
}
