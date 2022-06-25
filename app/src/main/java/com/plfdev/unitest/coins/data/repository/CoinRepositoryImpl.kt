package com.plfdev.unitest.coins.data.repository

import com.plfdev.unitest.coins.data.datasource.remote.abstraction.CoinRemoteDataSource
import com.plfdev.unitest.coins.domain.usecases.repository.CoinRepository

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