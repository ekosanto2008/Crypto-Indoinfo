package com.santoso.tech.data.remote.model

import com.google.gson.annotations.SerializedName

data class PriceConversionResponse(
    @SerializedName("data") val data: List<ConversionData>? = null,
    @SerializedName("status") val status: Status? = null
)

data class ConversionData(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("amount") val amount: Double? = null,
    @SerializedName("quote") val quote: Map<String, Quote>? = null
)
