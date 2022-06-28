package com.plfdev.unitest.common.di

import com.plfdev.unitest.coins.data.di.getCoinRemoteDataSourceModules
import com.plfdev.unitest.coins.data.di.getCoinRepositoryModules
import com.plfdev.unitest.coins.data.di.getCoinServiceModules
import com.plfdev.unitest.statistics.data.di.getStatisticsRemoteDataSourceModules
import com.plfdev.unitest.statistics.data.di.getStatisticsRepositoryModules
import com.plfdev.unitest.statistics.data.di.getStatisticsServiceModules

class DIDataModules {
    fun getRepositoryModules() = listOf(
        getCoinRepositoryModules(),
        getStatisticsRepositoryModules()
    )

    fun getDataSourceModules() = listOf(
        getCoinRemoteDataSourceModules(),
        getStatisticsRemoteDataSourceModules()
    )

    fun getServiceModules() = listOf(
        getCoinServiceModules(),
        getStatisticsServiceModules()
    )
}