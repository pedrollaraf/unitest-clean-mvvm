package com.plfdev.unitest.statistics.data.di

import com.plfdev.unitest.statistics.data.repository.StatisticsRepositoryImpl
import com.plfdev.unitest.statistics.domain.usecases.repository.StatisticsRepository
import org.koin.dsl.module

fun getStatisticsRepositoryModules() = module {
    factory<StatisticsRepository> {
        StatisticsRepositoryImpl(
            getStatisticsRemoteDataSource = get()
        )
    }
}