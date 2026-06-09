package com.santoso.tech.presentation.home

import com.santoso.tech.domain.model.Coin
import com.santoso.tech.domain.model.GlobalMetrics

data class HomeState(
    val coins: List<Coin> = emptyList(),
    val globalMetrics: GlobalMetrics? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
