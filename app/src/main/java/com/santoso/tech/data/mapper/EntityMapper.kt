package com.santoso.tech.data.mapper

import com.santoso.tech.data.local.entity.CoinEntity
import com.santoso.tech.domain.model.Coin

fun Coin.toEntity(): CoinEntity {
    return CoinEntity(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        price = price,
        marketCap = marketCap,
        volume24h = volume24h,
        percentChange1h = percentChange1h,
        percentChange24h = percentChange24h,
        percentChange7d = percentChange7d,
        logoUrl = logoUrl,
        description = description
    )
}

fun CoinEntity.toDomain(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        price = price,
        marketCap = marketCap,
        volume24h = volume24h,
        percentChange1h = percentChange1h,
        percentChange24h = percentChange24h,
        percentChange7d = percentChange7d,
        logoUrl = logoUrl,
        description = description
    )
}
