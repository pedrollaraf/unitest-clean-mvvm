package com.plfdev.unitest.common

import java.io.FileNotFoundException
import java.net.URL

internal object FileReaderHelper {
    fun readFileFromResources(fileName: String): String {
        val stream = javaClass.classLoader?.getResourceAsStream(fileName)
        return stream?.bufferedReader()?.readText() ?: ""
    }

    fun readFile(path: String): String {
        val content: URL? = ClassLoader.getSystemResource(path)
        return content?.readText() ?: throw FileNotFoundException("file path: $path was not found")
    }
}