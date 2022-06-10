package com.plfdev.unitest.coin.domain.di

import com.plfdev.unitest.coin.domain.usecases.abstraction.CoinUseCase
import com.plfdev.unitest.coin.domain.usecases.implementation.CoinUseCaseImpl
import org.koin.dsl.module

fun getCoinDomainModules() = module {
    factory<CoinUseCase> {
        CoinUseCaseImpl(
            getCoinsRepository = get()
        )
    }
}