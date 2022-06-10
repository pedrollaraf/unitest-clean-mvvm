package com.plfdev.unitest.coin.domain.usecases.repository

interface CoinRepository {
    suspend fun getCoins(): List<String>
}