package com.santoso.tech.data.remote.model

import com.google.gson.annotations.SerializedName

data class FearAndGreedResponse(
    @SerializedName("data") val data: List<FearAndGreedData>? = null,
    @SerializedName("status") val status: Status? = null
)

data class FearAndGreedData(
    @SerializedName("value") val value: Int? = null,
    @SerializedName("value_classification") val valueClassification: String? = null,
    @SerializedName("timestamp") val timestamp: String? = null
)
