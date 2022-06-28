package com.plfdev.unitest.statistics.data.datasource.remote.implementation

import com.plfdev.unitest.common.exception.CoinException
import com.plfdev.unitest.common.network.Output
import com.plfdev.unitest.common.network.parseResponse
import com.plfdev.unitest.statistics.data.datasource.remote.abstraction.StatisticsRemoteDataSource
import com.plfdev.unitest.statistics.data.datasource.service.abstraction.StatisticsApi
import kotlinx.coroutines.delay

class StatisticsRemoteDataSourceImpl(
    private val serviceStatistics: StatisticsApi
): StatisticsRemoteDataSource {
    override suspend fun getCoinStatistics(tickerCoin: String): String {
        when (val result = serviceStatistics.getCoinStatistics(tickerCoin).parseResponse()) {
            is Output.Success -> {

            }
            is Output.Failure ->{
                throw CoinException()
            }
        }

        //val result = serviceStatistics.getCoinStatistics("BTC")
        //println("The result high is: " + result.body()?.ticker?.high)
        //delay(2000)
        return "Hello"
    }

    override suspend fun getCoinStatisticsTrades(tickerCoin: String): String {
        delay(3000)
        return "World"
    }
}