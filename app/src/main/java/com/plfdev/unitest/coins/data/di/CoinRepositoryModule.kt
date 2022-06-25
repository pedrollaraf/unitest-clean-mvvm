package com.plfdev.unitest.coins.data.di

import com.plfdev.unitest.coins.data.repository.CoinRepositoryImpl
import com.plfdev.unitest.coins.domain.usecases.repository.CoinRepository
import org.koin.dsl.module

fun getCoinRepositoryModules() = module {
    factory<CoinRepository> {
        CoinRepositoryImpl(
            getCoinsDataSource = get()
        )
    }
}