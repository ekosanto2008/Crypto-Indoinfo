package com.santoso.tech.data.remote.model

import com.google.gson.annotations.SerializedName

data class MetadataResponse(
    @SerializedName("data") val data: Map<String, CryptoMetadata>? = null,
    @SerializedName("status") val status: Status? = null
)

data class CryptoMetadata(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("category") val category: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("slug") val slug: String? = null,
    @SerializedName("logo") val logo: String? = null,
    @SerializedName("urls") val urls: MetadataUrls? = null
)

data class MetadataUrls(
    @SerializedName("website") val website: List<String>? = null,
    @SerializedName("twitter") val twitter: List<String>? = null,
    @SerializedName("reddit") val reddit: List<String>? = null,
    @SerializedName("message_board") val messageBoard: List<String>? = null,
    @SerializedName("announcement") val announcement: List<String>? = null,
    @SerializedName("chat") val chat: List<String>? = null,
    @SerializedName("explorer") val explorer: List<String>? = null,
    @SerializedName("source_code") val sourceCode: List<String>? = null,
    @SerializedName("technical_doc") val technicalDoc: List<String>? = null
)
