package com.plfdev.unitest.coin.presenter.ui.controller

import com.airbnb.epoxy.EpoxyController
import com.plfdev.unitest.coin.presenter.ui.holder.coinHolder

class MainEpoxyController : EpoxyController() {

    private var mList: List<String> = listOf()
    private var isLoading = false

    override fun buildModels() {
        if(isLoading){

        }else {
            mList.map {
                coinHolder {
                    id(it)
                    title(it)
                }
            }
        }
    }

    fun setData(simpleData: List<String>) {
        mList = simpleData
        requestModelBuild()
    }

    fun isLoading(loading: Boolean){
        isLoading = loading
    }
}