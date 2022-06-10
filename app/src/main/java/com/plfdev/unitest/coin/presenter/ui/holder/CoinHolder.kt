package com.plfdev.unitest.coin.presenter.ui.holder

import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.plfdev.unitest.R
import com.plfdev.unitest.databinding.HolderCoinBinding

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.holder_coin)
abstract class CoinHolder : EpoxyModelWithHolder<CoinHolder.MainCoinHolder>() {

    @EpoxyAttribute
    lateinit var title : String

    override fun bind(holder: MainCoinHolder){
        holder.viewBinding.apply {
            tickerCoin.text = title
        }
    }

    inner class MainCoinHolder : EpoxyHolder(){
        lateinit var viewBinding: HolderCoinBinding
        override fun bindView(itemView: View) {
            viewBinding = HolderCoinBinding.bind(itemView)
        }
    }
}