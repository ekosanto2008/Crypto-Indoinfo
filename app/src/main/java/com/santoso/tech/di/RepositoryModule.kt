package com.santoso.tech.di

import com.santoso.tech.data.repository.CryptoRepository
import com.santoso.tech.data.repository.CryptoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCryptoRepository(
        cryptoRepositoryImpl: CryptoRepositoryImpl
    ): CryptoRepository
}
