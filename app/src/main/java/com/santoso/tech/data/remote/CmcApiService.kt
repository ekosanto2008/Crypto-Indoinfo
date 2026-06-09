package com.santoso.tech.data.remote

import com.santoso.tech.data.remote.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface CmcApiService {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getLatestListings(
        @Query("start") start: Int = 1,
        @Query("limit") limit: Int = 100,
        @Query("convert") convert: String = "USD"
    ): ListingResponse

    @GET("v2/cryptocurrency/info")
    suspend fun getCryptoMetadata(
        @Query("id") ids: String // Comma separated IDs
    ): MetadataResponse

    @GET("v1/global-metrics/quotes/latest")
    suspend fun getGlobalMetrics(
        @Query("convert") convert: String = "USD"
    ): GlobalMetricsResponse

    @GET("v3/fear-and-greed/latest")
    suspend fun getFearAndGreedLatest(): FearAndGreedResponse

    @GET("v2/tools/price-conversion")
    suspend fun convertPrice(
        @Query("amount") amount: Double,
        @Query("symbol") symbol: String,
        @Query("convert") convert: String = "IDR"
    ): PriceConversionResponse
}
