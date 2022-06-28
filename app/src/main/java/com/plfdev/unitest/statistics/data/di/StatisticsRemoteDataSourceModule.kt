package com.plfdev.unitest.statistics.data.di


import com.plfdev.unitest.statistics.data.datasource.remote.abstraction.StatisticsRemoteDataSource
import com.plfdev.unitest.statistics.data.datasource.remote.implementation.StatisticsRemoteDataSourceImpl
import org.koin.dsl.module

fun getStatisticsRemoteDataSourceModules() = module {
    factory<StatisticsRemoteDataSource> {
        StatisticsRemoteDataSourceImpl(
            serviceStatistics = get()
        )
    }
}