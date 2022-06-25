package com.plfdev.unitest.coins.presenter.di

import com.plfdev.unitest.coins.presenter.viewmodel.CoinsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getCoinViewModelModules() = module {
    viewModel {
        CoinsViewModel(
            getCoinsUseCase = get()
        )
    }
}