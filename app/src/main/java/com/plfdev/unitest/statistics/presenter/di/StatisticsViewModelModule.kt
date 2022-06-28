package com.plfdev.unitest.statistics.presenter.di

import com.plfdev.unitest.statistics.presenter.viewmodel.StatisticsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getStatisticsViewModelModules() = module {
    viewModel {
        StatisticsViewModel(
            getStatisticsUseCases = get()
        )
    }
}