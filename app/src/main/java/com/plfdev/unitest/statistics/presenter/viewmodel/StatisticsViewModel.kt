package com.plfdev.unitest.statistics.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plfdev.unitest.statistics.domain.usecases.abstraction.StatisticsUseCases
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class StatisticsViewModel(
    private val getStatisticsUseCases: StatisticsUseCases
) : ViewModel() {
    fun getStatistics(tickerCoin: String) {
        viewModelScope.launch {
            coroutineScope {
                val coinStatistics = async { getStatisticsUseCases.getCoinStatistics(tickerCoin) }
                val coinStatisticsTrades = async { getStatisticsUseCases.getCoinStatisticsTrades(tickerCoin) }

                val resultCoinStatistics = coinStatistics.await()
                val resultCoinStatisticsTrades = coinStatisticsTrades.await()
                println("The result is $resultCoinStatistics $resultCoinStatisticsTrades")

                //val one = async { getFirstResultFromInternet() }
                //val two = async { getSecondResultFromInternet() }
                //println("The result is ${one.await()} ${two.await()}")
            }
        }
    }

    /*private suspend fun getFirstResultFromInternet(): String {
        println("Getting First Result From Internet")
        delay(2000) // add some delay
        return "Hello"
    }

    private suspend fun getSecondResultFromInternet(): String {
        println("Getting Second Result From Internet")
        delay(4000) // add some delay
        return "World"
    }*/
}
