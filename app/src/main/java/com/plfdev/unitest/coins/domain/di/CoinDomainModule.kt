package com.plfdev.unitest.coins.domain.di

import com.plfdev.unitest.coins.domain.usecases.abstraction.CoinUseCase
import com.plfdev.unitest.coins.domain.usecases.implementation.CoinUseCaseImpl
import org.koin.dsl.module

fun getCoinDomainModules() = module {
    factory<CoinUseCase> {
        CoinUseCaseImpl(
            getCoinsRepository = get()
        )
    }
}