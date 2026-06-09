package com.santoso.tech.domain.model

data class CoinDetail(
    val id: Int,
    val name: String,
    val symbol: String,
    val logo: String,
    val description: String,
    val website: String?,
    val twitter: String?,
    val reddit: String?,
    val sourceCode: String?,
    val technicalDoc: String?,
    val explorer: String?
)
