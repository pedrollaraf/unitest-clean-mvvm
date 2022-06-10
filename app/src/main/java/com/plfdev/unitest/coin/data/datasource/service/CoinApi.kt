package com.plfdev.unitest.coin.data.datasource.service

import retrofit2.Response
import retrofit2.http.GET

interface CoinApi {

    @GET("coins")
    suspend fun getCoins(): Response<List<String>>

}