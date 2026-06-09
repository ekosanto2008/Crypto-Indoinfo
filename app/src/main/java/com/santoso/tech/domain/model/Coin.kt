package com.santoso.tech.domain.model

data class Coin(
    val id: Int,
    val name: String,
    val symbol: String,
    val rank: Int,
    val price: Double,
    val marketCap: Double,
    val volume24h: Double,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
    val logoUrl: String? = null,
    val description: String? = null
)
