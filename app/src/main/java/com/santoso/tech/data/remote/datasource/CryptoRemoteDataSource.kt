package com.santoso.tech.data.remote.datasource

import com.santoso.tech.data.remote.CmcApiService
import com.santoso.tech.data.remote.model.*
import javax.inject.Inject

class CryptoRemoteDataSource @Inject constructor(
    private val apiService: CmcApiService
) {
    suspend fun getLatestListings(start: Int = 1, limit: Int = 100): ListingResponse {
        return apiService.getLatestListings(start = start, limit = limit)
    }

    suspend fun getCryptoMetadata(ids: String): MetadataResponse {
        return apiService.getCryptoMetadata(ids)
    }

    suspend fun getGlobalMetrics(): GlobalMetricsResponse {
        return apiService.getGlobalMetrics()
    }

    suspend fun getFearAndGreedLatest(): FearAndGreedResponse {
        return apiService.getFearAndGreedLatest()
    }

    suspend fun convertPrice(amount: Double, symbol: String): PriceConversionResponse {
        return apiService.convertPrice(amount = amount, symbol = symbol)
    }
}
