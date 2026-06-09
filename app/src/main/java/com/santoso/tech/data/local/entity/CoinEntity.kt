package com.santoso.tech.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins")
data class CoinEntity(
    @PrimaryKey val id: Int,
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
