package com.plfdev.unitest.coins.domain.usecases.implementation

import com.plfdev.unitest.coins.domain.usecases.abstraction.CoinUseCase
import com.plfdev.unitest.coins.domain.usecases.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class CoinUseCaseImpl(
    private val getCoinsRepository: CoinRepository
): CoinUseCase {
    override suspend fun getCoins(): List<String> {
        //Neste caso não seria necessario o UseCases pois não há regra de negocio
        //Poderia apenas usar o repository diretamente
        return getCoinsRepository.getCoins()
    }
}