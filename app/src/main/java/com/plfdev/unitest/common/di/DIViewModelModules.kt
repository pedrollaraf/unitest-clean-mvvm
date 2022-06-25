package com.plfdev.unitest.common.di

import com.plfdev.unitest.coins.presenter.di.getCoinViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf(
        getCoinViewModelModules()
    )
}