package com.plfdev.unitest.coin.data.repository

import com.plfdev.unitest.coin.data.datasource.remote.abstraction.CoinRemoteDataSource
import com.plfdev.unitest.coin.domain.usecases.repository.CoinRepository

class CoinRepositoryImpl (
    private val getCoinsDataSource: CoinRemoteDataSource
): CoinRepository {
    override suspend fun getCoins(): List<String> {
        return try {
            getCoinsDataSource.getCoins()
        } catch (ex: Exception) {
            listOf()
        }
    }
}