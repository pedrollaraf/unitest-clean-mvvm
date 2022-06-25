package com.plfdev.unitest.coin.data.repository

import com.plfdev.unitest.common.MockCoinFactory
import com.plfdev.unitest.common.exception.CoinException
import com.plfdev.unitest.coins.data.datasource.remote.implementation.CoinRemoteDataSourceImpl
import com.plfdev.unitest.coins.data.repository.CoinRepositoryImpl
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CoinRepositoryImplTest {

    private val datasource = mockk<CoinRemoteDataSourceImpl>()
    private val coins = CoinRepositoryImpl(datasource)

    @Test
    fun `get list coins with success`() = runBlocking {
        //GIVEN
        coEvery { datasource.getCoins() } returns MockCoinFactory.coins
        //WHEN
        val result = coins.getCoins()
        //THEN
        result shouldBe MockCoinFactory.coins
    }

    @Test
    fun `get list coins with empty list success`() = runBlocking {
        //GIVEN
        coEvery { datasource.getCoins() } returns listOf()
        //WHEN
        val result = coins.getCoins()
        //THEN
        result shouldBe listOf()
    }

    @Test
    fun `get list coins exception`() = runBlocking {
        //GIVEN
        coEvery { datasource.getCoins() } throws CoinException()
        //WHEN
        val result = coins.getCoins()
        //THEN
        result.size shouldBe 0
    }
}