package com.plfdev.unitest.common.di

import com.plfdev.unitest.coins.domain.di.getCoinDomainModules
import com.plfdev.unitest.statistics.domain.di.getStatisticsDomainModules

class DIDomainModules {
    fun getDomainModules() = listOf(
        getCoinDomainModules(),
        getStatisticsDomainModules()
    )
}