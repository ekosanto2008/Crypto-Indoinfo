package com.santoso.tech.domain.usecase

import com.santoso.tech.data.repository.CryptoRepository
import com.santoso.tech.domain.model.GlobalMetrics
import com.santoso.tech.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGlobalMetricsUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    operator fun invoke(): Flow<Resource<GlobalMetrics>> {
        return repository.getGlobalMetrics()
    }
}
