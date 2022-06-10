package com.plfdev.unitest.coin.data.datasource.remote.abstraction

interface CoinRemoteDataSource {
    suspend fun getCoins() : List<String>
}