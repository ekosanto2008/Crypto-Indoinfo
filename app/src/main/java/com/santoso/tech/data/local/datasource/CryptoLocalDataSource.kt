package com.santoso.tech.data.local.datasource

import com.santoso.tech.data.local.dao.CoinDao
import com.santoso.tech.data.local.entity.CoinEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoLocalDataSource @Inject constructor(
    private val coinDao: CoinDao
) {
    fun getCoins(): Flow<List<CoinEntity>> = coinDao.getCoins()

    suspend fun insertCoins(coins: List<CoinEntity>) = coinDao.insertCoins(coins)

    suspend fun deleteAllCoins() = coinDao.deleteAllCoins()
}
