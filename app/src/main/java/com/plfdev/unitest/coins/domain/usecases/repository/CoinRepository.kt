package com.plfdev.unitest.coins.domain.usecases.repository

interface CoinRepository {
    suspend fun getCoins(): List<String>
}