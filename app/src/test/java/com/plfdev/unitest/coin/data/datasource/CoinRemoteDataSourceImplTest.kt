package com.plfdev.unitest.coin.data.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.plfdev.unitest.coin.common.FileReaderHelper.readFile
import com.plfdev.unitest.coin.common.FileReaderHelper.readFileFromResources
import com.plfdev.unitest.coin.data.datasource.remote.implementation.CoinRemoteDataSourceImpl
import com.plfdev.unitest.coin.data.datasource.service.CoinApi
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import okhttp3.OkHttpClient.Builder
import io.kotest.matchers.string.contain
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class CoinRemoteDataSourceImplTest(): AutoCloseKoinTest() {

    private val server = MockWebServer()
    private val retrofit: Retrofit by inject()
    private lateinit var dataSource: CoinRemoteDataSourceImpl

    private val mockModule: Module by lazy {
        module {
            single {
                val okHttp = Builder()
                    .build()

                Retrofit.Builder()
                    .baseUrl(server.url("/"))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttp)
                    .build()
            }
        }
    }

    @Before
    fun setUp() {
        server.start()
        startKoin {
            modules(mockModule)
        }
        dataSource = CoinRemoteDataSourceImpl(retrofit.create(CoinApi::class.java))
    }

    @Test
    fun `test success response`() = runBlocking {
        server.enqueue(MockResponse().setResponseCode(200).setBody(readFile("coins.json")))
        val response = dataSource.getCoins()
        val request = server.takeRequest()
        val expectedResponse = getCoinsResponse()
        server.shutdown()

        request.requestUrl.toString() should contain("coins")
        response.size shouldBe expectedResponse.size
        response[0] shouldBe expectedResponse[0]
        response[1] shouldBe expectedResponse[1]
        response[2] shouldBe expectedResponse[2]
        response[3] shouldBe expectedResponse[3]
        response[4] shouldBe expectedResponse[4]
    }

    private fun getCoinsResponse(): List<String>{
        val arrayTutorialType = object : TypeToken<List<String>>() {}.type
        val gson = Gson()
        return gson.fromJson(readFileFromResources("coins.json"),arrayTutorialType)
    }

/*    @Test
    fun `get answer returns error`() = runBlocking {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
            .setBody("unknown error")
        mockRetrofitHelper.mockServer.enqueue(response)
        var result: GetAnswerResponse? = null
        var exception: Exception? = null
        try {
            result = dataSource.getAnswer(1L, 1L)
        } catch (e: Exception) {
            exception = e
        }
        result shouldBe null
        exception.shouldBeInstanceOf<NetworkException>()
        exception.message shouldBe "unknown error"

        @Test
    fun `get answer invalid session error`() = runBlocking {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
            .setBody(SessionException.SESSION_EXCEPTION_MESSAGE)
        mockRetrofitHelper.mockServer.enqueue(response)
        var result: GetAnswerResponse? = null
        var exception: Exception? = null
        try {
            result = dataSource.getAnswer(1L, 1L)
        } catch (e: Exception) {
            exception = e
        }
        result shouldBe null
        exception.shouldBeInstanceOf<NetworkException>()
        exception.message shouldBe SessionException.SESSION_EXCEPTION_MESSAGE
    }

    @Test
    fun `get answer invalid api key error`() = runBlocking {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
            .setBody(InvalidApiKeyException.INVALID_API_KEY_MESSAGE)
        mockRetrofitHelper.mockServer.enqueue(response)
        var result: GetAnswerResponse? = null
        var exception: Exception? = null
        try {
            result = dataSource.getAnswer(1L, 1L)
        } catch (e: Exception) {
            exception = e
        }
        result shouldBe null
        exception.shouldBeInstanceOf<NetworkException>()
        exception.message shouldBe InvalidApiKeyException.INVALID_API_KEY_MESSAGE
    }


    }*/

}