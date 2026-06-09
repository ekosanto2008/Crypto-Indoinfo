package com.santoso.tech.data.repository

import com.santoso.tech.domain.model.Coin
import com.santoso.tech.domain.model.CoinDetail
import com.santoso.tech.domain.model.GlobalMetrics
import com.santoso.tech.util.Resource
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCoins(): Flow<Resource<List<Coin>>>
    fun getCoinDetail(id: Int): Flow<Resource<CoinDetail>>
    fun getGlobalMetrics(): Flow<Resource<GlobalMetrics>>
}
