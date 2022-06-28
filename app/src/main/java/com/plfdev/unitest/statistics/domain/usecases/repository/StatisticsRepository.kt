package com.plfdev.unitest.statistics.domain.usecases.repository

interface StatisticsRepository {
    suspend fun getCoinStatistics(tickerCoin: String): String
    suspend fun getCoinStatisticsTrades(tickerCoin: String): String
}