package com.plfdev.unitest.common.di

import com.plfdev.unitest.coins.data.di.getCoinRemoteDataSourceModules
import com.plfdev.unitest.coins.data.di.getCoinRepositoryModules
import com.plfdev.unitest.coins.data.di.getCoinServiceModules

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