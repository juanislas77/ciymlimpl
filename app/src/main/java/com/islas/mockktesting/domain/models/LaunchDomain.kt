package com.islas.mockktesting.domain.models

data class LaunchDomain(
    val id: String,
    val nameLaunched: String,
    val dateLaunchedLocal: String,
    val logoLaunched: String,
    val article: String,
    val description: String,
    val original: List<String>,
)
