package com.santoso.tech.data.local.dao

import androidx.room.*
import com.santoso.tech.data.local.entity.CoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {
    @Query("SELECT * FROM coins ORDER BY rank ASC")
    fun getCoins(): Flow<List<CoinEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins: List<CoinEntity>)

    @Query("DELETE FROM coins")
    suspend fun deleteAllCoins()
}
