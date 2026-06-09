package com.santoso.tech.data.remote.model

import com.google.gson.annotations.SerializedName

data class ListingResponse(
    @SerializedName("data") val data: List<CryptoListing>? = null,
    @SerializedName("status") val status: Status? = null
)

data class CryptoListing(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("slug") val slug: String? = null,
    @SerializedName("cmc_rank") val cmcRank: Int? = null,
    @SerializedName("quote") val quote: Map<String, Quote>? = null
)
