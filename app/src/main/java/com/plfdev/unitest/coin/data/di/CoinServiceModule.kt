package com.plfdev.unitest.coin.data.di

import com.plfdev.unitest.coin.common.network.ApiConnector
import com.plfdev.unitest.coin.data.datasource.service.CoinApi
import org.koin.dsl.module

fun getCoinServiceModules() = module {
    factory { ApiConnector().createService(CoinApi::class.java) }
}