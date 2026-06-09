package com.santoso.tech.presentation.detail

import com.santoso.tech.domain.model.CoinDetail

data class DetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
