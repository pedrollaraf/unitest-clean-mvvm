package com.plfdev.unitest.coins.domain.usecases.abstraction

interface CoinUseCase {
    suspend fun getCoins(): List<String>
}