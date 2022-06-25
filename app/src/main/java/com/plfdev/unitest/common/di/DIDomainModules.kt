package com.plfdev.unitest.common.di

import com.plfdev.unitest.coins.domain.di.getCoinDomainModules

class DIDomainModules {
    fun getDomainModules() = listOf(
        getCoinDomainModules()
    )
}