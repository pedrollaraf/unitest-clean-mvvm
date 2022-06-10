package com.plfdev.unitest.coin.presenter.di

import com.plfdev.unitest.coin.presenter.viewmodel.CoinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getCoinViewModelModules() = module {
    viewModel {
        CoinViewModel(
            getCoinsUseCase = get()
        )
    }
}