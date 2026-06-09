package com.santoso.tech.domain.model

data class GlobalMetrics(
    val totalMarketCap: Double,
    val totalVolume24h: Double,
    val btcDominance: Double,
    val fearAndGreedValue: Int,
    val fearAndGreedClassification: String,
    val usdToIdrRate: Double
)
