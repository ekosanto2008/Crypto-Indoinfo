package com.santoso.tech.data.repository

import com.santoso.tech.data.local.datasource.CryptoLocalDataSource
import com.santoso.tech.data.mapper.toCoinDetail
import com.santoso.tech.data.mapper.toDomain
import com.santoso.tech.data.mapper.toEntity
import com.santoso.tech.data.remote.datasource.CryptoRemoteDataSource
import com.santoso.tech.domain.model.Coin
import com.santoso.tech.domain.model.CoinDetail
import com.santoso.tech.domain.model.GlobalMetrics
import com.santoso.tech.util.Resource
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val remoteDataSource: CryptoRemoteDataSource,
    private val localDataSource: CryptoLocalDataSource
) : CryptoRepository {

    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        
        // Emisi data dari local cache dulu
        val localCoins = localDataSource.getCoins().first().map { it.toDomain() }
        if (localCoins.isNotEmpty()) {
            emit(Resource.Success(localCoins))
        }

        try {
            val response = remoteDataSource.getLatestListings()
            val listings = response.data ?: emptyList()
            
            val topListings = listings.take(50)
            val ids = topListings.joinToString(",") { it.id.toString() }
            
            val coins = if (ids.isNotEmpty()) {
                try {
                    val infoResponse = remoteDataSource.getCryptoMetadata(ids)
                    val metadataMap = infoResponse.data
                    topListings.map { item ->
                        item.toDomain(metadataMap?.get(item.id.toString()))
                    }
                } catch (e: Exception) {
                    topListings.map { it.toDomain() }
                }
            } else {
                emptyList()
            }

            if (coins.isNotEmpty()) {
                localDataSource.deleteAllCoins()
                localDataSource.insertCoins(coins.map { it.toEntity() })
                emit(Resource.Success(coins))
            }

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred", localCoins))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection.", localCoins))
        }
    }

    override fun getCoinDetail(id: Int): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        try {
            val infoResponse = remoteDataSource.getCryptoMetadata(id.toString())
            val metadata = infoResponse.data?.get(id.toString())
            
            if (metadata != null) {
                emit(Resource.Success(metadata.toCoinDetail()))
            } else {
                emit(Resource.Error("Coin not found"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }
    }

    override fun getGlobalMetrics(): Flow<Resource<GlobalMetrics>> = flow {
        emit(Resource.Loading())
        try {
            val globalResponse = remoteDataSource.getGlobalMetrics()
            val fearAndGreedResponse = remoteDataSource.getFearAndGreedLatest()
            
            var idrRate = 15000.0
            try {
                val conversionResponse = remoteDataSource.convertPrice(amount = 1.0, symbol = "USD")
                idrRate = conversionResponse.data?.firstOrNull()?.quote?.get("IDR")?.price ?: 15000.0
            } catch (e: Exception) {
                // ignore
            }
            
            val globalData = globalResponse.data
            val usdQuote = globalData?.quote?.get("USD")
            val fearAndGreed = fearAndGreedResponse.data?.firstOrNull()
            
            val metrics = GlobalMetrics(
                totalMarketCap = usdQuote?.totalMarketCap ?: 0.0,
                totalVolume24h = usdQuote?.totalVolume24h ?: 0.0,
                btcDominance = globalData?.btcDominance ?: 0.0,
                fearAndGreedValue = fearAndGreed?.value ?: 0,
                fearAndGreedClassification = fearAndGreed?.valueClassification ?: "Unknown",
                usdToIdrRate = idrRate
            )
            emit(Resource.Success(metrics))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }
    }
}
