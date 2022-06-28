package com.plfdev.unitest.statistics.data.repository

import com.plfdev.unitest.statistics.data.datasource.remote.abstraction.StatisticsRemoteDataSource
import com.plfdev.unitest.statistics.domain.usecases.repository.StatisticsRepository

class StatisticsRepositoryImpl(
    private val getStatisticsRemoteDataSource: StatisticsRemoteDataSource
): StatisticsRepository {
    override suspend fun getCoinStatistics(tickerCoin: String): String {
        return getStatisticsRemoteDataSource.getCoinStatistics(tickerCoin)
    }

    override suspend fun getCoinStatisticsTrades(tickerCoin: String): String {
        return getStatisticsRemoteDataSource.getCoinStatisticsTrades(tickerCoin)
    }
}