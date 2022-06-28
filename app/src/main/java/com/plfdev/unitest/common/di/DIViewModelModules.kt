package com.plfdev.unitest.common.di

import com.plfdev.unitest.coins.presenter.di.getCoinViewModelModules
import com.plfdev.unitest.statistics.presenter.di.getStatisticsViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf(
        getCoinViewModelModules(),
        getStatisticsViewModelModules()
    )
}