package com.plfdev.unitest.coin.common.di

import com.plfdev.unitest.coin.data.di.getCoinRemoteDataSourceModules
import com.plfdev.unitest.coin.data.di.getCoinRepositoryModules
import com.plfdev.unitest.coin.data.di.getCoinServiceModules

class DIDataModules {
    fun getRepositoryModules() = listOf(
        getCoinRepositoryModules()
    )

    fun getDataSourceModules() = listOf(
        getCoinRemoteDataSourceModules()
    )

    fun getServiceModules() = listOf(
        getCoinServiceModules()
    )
}