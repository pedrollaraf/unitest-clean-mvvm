package com.plfdev.unitest.coins.data.di

import com.plfdev.unitest.common.network.ApiConnector
import com.plfdev.unitest.coins.data.datasource.service.CoinApi
import org.koin.dsl.module

fun getCoinServiceModules() = module {
    factory { ApiConnector().createService(CoinApi::class.java) }
}