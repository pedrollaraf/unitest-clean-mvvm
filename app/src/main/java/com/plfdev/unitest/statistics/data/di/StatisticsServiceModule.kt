package com.plfdev.unitest.statistics.data.di


import com.plfdev.unitest.common.network.ApiConnector
import com.plfdev.unitest.statistics.data.datasource.service.abstraction.StatisticsApi
import org.koin.dsl.module

fun getStatisticsServiceModules() = module {
    factory { ApiConnector().createService(StatisticsApi::class.java) }
}