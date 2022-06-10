package com.plfdev.unitest.coin.common.di

import com.plfdev.unitest.coin.domain.di.getCoinDomainModules

class DIDomainModules {
    fun getDomainModules() = listOf(
        getCoinDomainModules()
    )
}