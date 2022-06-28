package com.plfdev.unitest.statistics.domain.di

import com.plfdev.unitest.statistics.domain.usecases.abstraction.StatisticsUseCases
import com.plfdev.unitest.statistics.domain.usecases.implementation.StatisticsUseCasesImpl
import org.koin.dsl.module

fun getStatisticsDomainModules() = module {
    factory<StatisticsUseCases> {
        StatisticsUseCasesImpl(
            getStatisticsRepository = get()
        )
    }
}