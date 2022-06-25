package com.plfdev.unitest.coins.data.datasource.remote.implementation

import com.plfdev.unitest.common.exception.CoinException
import com.plfdev.unitest.common.network.Output
import com.plfdev.unitest.common.network.parseResponse
import com.plfdev.unitest.coins.data.datasource.remote.abstraction.CoinRemoteDataSource
import com.plfdev.unitest.coins.data.datasource.service.CoinApi


class CoinRemoteDataSourceImpl(
    private val serviceCoin : CoinApi
): CoinRemoteDataSource {
    override suspend fun getCoins(): List<String> {
        return when (val result = serviceCoin.getCoins().parseResponse()) {
            is Output.Success -> {
                result.value.ifEmpty {
                    listOf()
                }
            }
            is Output.Failure ->{
                throw CoinException()
            }
        }
    }
}