package com.plfdev.unitest.coin.common

internal object FileReaderHelper {
    fun readFileFromResources(fileName: String): String {
        val stream = javaClass.classLoader?.getResourceAsStream(fileName)
        return stream?.bufferedReader()?.readText() ?: ""
    }
}