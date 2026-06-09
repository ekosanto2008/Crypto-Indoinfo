package com.santoso.tech.data.remote.model

import com.google.gson.annotations.SerializedName

data class GlobalMetricsResponse(
    @SerializedName("data") val data: GlobalData? = null,
    @SerializedName("status") val status: Status? = null
)

data class GlobalData(
    @SerializedName("active_cryptocurrencies") val activeCryptocurrencies: Int? = null,
    @SerializedName("btc_dominance") val btcDominance: Double? = null,
    @SerializedName("eth_dominance") val ethDominance: Double? = null,
    @SerializedName("quote") val quote: Map<String, GlobalQuote>? = null
)

data class GlobalQuote(
    @SerializedName("total_market_cap") val totalMarketCap: Double? = null,
    @SerializedName("total_volume_24h") val totalVolume24h: Double? = null,
    @SerializedName("last_updated") val lastUpdated: String? = null
)
