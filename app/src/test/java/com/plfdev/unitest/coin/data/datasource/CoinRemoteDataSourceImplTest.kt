package com.plfdev.unitest.coin.data.datasource

import com.plfdev.unitest.coin.common.FileReaderHelper
import com.plfdev.unitest.coin.common.network.ApiConnector
import com.plfdev.unitest.coin.data.datasource.remote.implementation.CoinRemoteDataSourceImpl
import com.plfdev.unitest.coin.data.datasource.service.CoinApi
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class CoinRemoteDataSourceImplTest {

    /*private val mockServer = MockWebServer()
    private lateinit var dataSource: CoinRemoteDataSourceImpl

    private val mockModule: Module by lazy {
        module {
            single {
                val okHttp = OkHttpClient.Builder()
                    .build()

                Retrofit.Builder()
                    .baseUrl(mockServer.url("/"))
                    .client(okHttp)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            }
        }
    }

    @Before
    fun setup() {
        startKoin { modules(mockModule) }
        dataSource = CoinRemoteDataSourceImpl(ApiConnector().createService(CoinApi::class.java))
    }


    @Test
    fun `test success response`() = runBlocking {
        val successResponse = MockResponse()
            .setResponseCode(200)
            .setBody(FileReaderHelper.readFileFromResources("coins.json"))

        mockServer.enqueue(successResponse)
        val response = dataSource.getCoins()
        val request = mockServer.takeRequest()

        response shouldBe getCoinsResponse()
    }

    private fun getCoinsResponse(): List<String> {
        val json = FileReaderHelper.readFileFromResources("coins.json")
        return listOf()
    }*/

}