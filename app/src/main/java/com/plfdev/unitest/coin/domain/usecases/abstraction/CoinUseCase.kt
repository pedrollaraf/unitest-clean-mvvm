package com.plfdev.unitest.coin.domain.usecases.abstraction

interface CoinUseCase {
    suspend fun getCoins(): List<String>
}