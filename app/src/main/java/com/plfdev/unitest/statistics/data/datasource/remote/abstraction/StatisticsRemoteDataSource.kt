package com.plfdev.unitest.statistics.data.datasource.remote.abstraction

interface StatisticsRemoteDataSource {
    suspend fun getCoinStatistics(tickerCoin: String): String
    suspend fun getCoinStatisticsTrades(tickerCoin: String): String
}