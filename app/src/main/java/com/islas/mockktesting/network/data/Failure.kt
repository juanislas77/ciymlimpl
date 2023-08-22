package com.islas.mockktesting.network.data

import com.google.gson.annotations.SerializedName

data class Failure(
    @SerializedName("altitude")
    val altitude: Int,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("time")
    val time: Int
)