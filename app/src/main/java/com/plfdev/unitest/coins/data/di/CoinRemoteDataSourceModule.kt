package com.plfdev.unitest.coins.data.di

import com.plfdev.unitest.coins.data.datasource.remote.implementation.CoinRemoteDataSourceImpl
import com.plfdev.unitest.coins.data.datasource.remote.abstraction.CoinRemoteDataSource
import org.koin.dsl.module

fun getCoinRemoteDataSourceModules() = module {
    factory<CoinRemoteDataSource> {
        CoinRemoteDataSourceImpl(
            serviceCoin = get()
        )
    }
}