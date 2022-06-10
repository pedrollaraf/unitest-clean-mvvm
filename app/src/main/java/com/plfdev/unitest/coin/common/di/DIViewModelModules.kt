package com.plfdev.unitest.coin.common.di

import com.plfdev.unitest.coin.presenter.di.getCoinViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf(
        getCoinViewModelModules()
    )
}