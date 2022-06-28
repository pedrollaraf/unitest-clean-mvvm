package com.plfdev.unitest.statistics.domain.usecases.abstraction

interface StatisticsUseCases {
    suspend fun getCoinStatistics(tickerCoin: String): String
    suspend fun getCoinStatisticsTrades(tickerCoin: String): String
}