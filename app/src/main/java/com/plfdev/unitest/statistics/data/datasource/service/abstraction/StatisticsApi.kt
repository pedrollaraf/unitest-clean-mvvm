package com.plfdev.unitest.statistics.data.datasource.service.abstraction

import com.plfdev.unitest.statistics.data.datasource.remote.modelresponse.CoinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StatisticsApi {
    @GET("{coin}/ticker")
    suspend fun getCoinStatistics(@Path("coin") coin: String): Response<CoinResponse>
}