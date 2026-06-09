package com.santoso.tech.domain.usecase

import com.santoso.tech.data.repository.CryptoRepository
import com.santoso.tech.domain.model.CoinDetail
import com.santoso.tech.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    operator fun invoke(id: Int): Flow<Resource<CoinDetail>> {
        return repository.getCoinDetail(id)
    }
}
