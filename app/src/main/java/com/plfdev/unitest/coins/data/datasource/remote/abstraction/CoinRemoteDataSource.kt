package com.plfdev.unitest.coins.data.datasource.remote.abstraction

interface CoinRemoteDataSource {
    suspend fun getCoins() : List<String>
}