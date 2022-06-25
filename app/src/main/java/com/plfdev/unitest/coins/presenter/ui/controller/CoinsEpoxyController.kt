package com.plfdev.unitest.coins.presenter.ui.controller

import com.airbnb.epoxy.EpoxyController
import com.plfdev.unitest.coins.presenter.ui.holder.coinsHolder

class CoinsEpoxyController(
    private var coinsClick: CoinsClick
) : EpoxyController() {

    private var mList: List<String> = listOf()


    interface CoinsClick{
        fun onCoinClick(ticker: String)
    }

    override fun buildModels() {
        mList.map {
            coinsHolder {
                id(it)
                title(it)
                coinClick(coinsClick::onCoinClick)
            }
        }
    }

    fun setData(simpleData: List<String>) {
        mList = simpleData
        requestModelBuild()
    }
}