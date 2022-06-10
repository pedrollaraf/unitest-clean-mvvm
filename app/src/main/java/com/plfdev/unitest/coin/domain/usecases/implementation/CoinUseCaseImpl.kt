package com.plfdev.unitest.coin.domain.usecases.implementation

import com.plfdev.unitest.coin.domain.usecases.abstraction.CoinUseCase
import com.plfdev.unitest.coin.domain.usecases.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class CoinUseCaseImpl(
    private val getCoinsRepository: CoinRepository
): CoinUseCase {
    override suspend fun getCoins(): List<String> {
        return getCoinsRepository.getCoins()
    }
}