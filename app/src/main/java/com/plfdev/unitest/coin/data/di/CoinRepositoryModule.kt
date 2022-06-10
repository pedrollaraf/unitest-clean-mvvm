package com.plfdev.unitest.coin.data.di

import com.plfdev.unitest.coin.data.repository.CoinRepositoryImpl
import com.plfdev.unitest.coin.domain.usecases.repository.CoinRepository
import org.koin.dsl.module

fun getCoinRepositoryModules() = module {
    factory<CoinRepository> {
        CoinRepositoryImpl(
            getCoinsDataSource = get()
        )
    }
}