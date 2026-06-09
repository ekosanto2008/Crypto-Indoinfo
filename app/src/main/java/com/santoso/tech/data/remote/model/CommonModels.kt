package com.santoso.tech.data.remote.model

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("timestamp") val timestamp: String? = null,
    @SerializedName("error_code") val errorCode: Int? = null,
    @SerializedName("error_message") val errorMessage: String? = null,
    @SerializedName("credit_count") val creditCount: Int? = null
)

data class Quote(
    @SerializedName("price") val price: Double? = null,
    @SerializedName("volume_24h") val volume24h: Double? = null,
    @SerializedName("percent_change_1h") val percentChange1h: Double? = null,
    @SerializedName("percent_change_24h") val percentChange24h: Double? = null,
    @SerializedName("percent_change_7d") val percentChange7d: Double? = null,
    @SerializedName("market_cap") val marketCap: Double? = null,
    @SerializedName("last_updated") val lastUpdated: String? = null
)
