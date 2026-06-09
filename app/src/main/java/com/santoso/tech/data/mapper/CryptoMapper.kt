package com.santoso.tech.data.mapper

import com.santoso.tech.data.remote.model.CryptoListing
import com.santoso.tech.data.remote.model.CryptoMetadata
import com.santoso.tech.domain.model.Coin

import com.santoso.tech.domain.model.CoinDetail

fun CryptoListing.toDomain(metadata: CryptoMetadata? = null): Coin {
    val usdQuote = quote?.get("USD")
    return Coin(
        id = id ?: 0,
        name = name ?: "",
        symbol = symbol ?: "",
        rank = cmcRank ?: 0,
        price = usdQuote?.price ?: 0.0,
        marketCap = usdQuote?.marketCap ?: 0.0,
        volume24h = usdQuote?.volume24h ?: 0.0,
        percentChange1h = usdQuote?.percentChange1h ?: 0.0,
        percentChange24h = usdQuote?.percentChange24h ?: 0.0,
        percentChange7d = usdQuote?.percentChange7d ?: 0.0,
        logoUrl = metadata?.logo,
        description = metadata?.description
    )
}

fun CryptoMetadata.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id = id ?: 0,
        name = name ?: "",
        symbol = symbol ?: "",
        logo = logo ?: "",
        description = description ?: "",
        website = urls?.website?.firstOrNull(),
        twitter = urls?.twitter?.firstOrNull(),
        reddit = urls?.reddit?.firstOrNull(),
        sourceCode = urls?.sourceCode?.firstOrNull(),
        technicalDoc = urls?.technicalDoc?.firstOrNull(),
        explorer = urls?.explorer?.firstOrNull()
    )
}
