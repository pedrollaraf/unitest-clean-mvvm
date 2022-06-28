package com.plfdev.unitest.statistics.domain.usecases.implementation

import com.plfdev.unitest.statistics.domain.usecases.abstraction.StatisticsUseCases
import com.plfdev.unitest.statistics.domain.usecases.repository.StatisticsRepository

class StatisticsUseCasesImpl(
    private val getStatisticsRepository: StatisticsRepository
): StatisticsUseCases {
    override suspend fun getCoinStatistics(tickerCoin: String): String {
        return getStatisticsRepository.getCoinStatistics(tickerCoin)
    }

    override suspend fun getCoinStatisticsTrades(tickerCoin: String): String {
        return getStatisticsRepository.getCoinStatisticsTrades(tickerCoin)
    }
}