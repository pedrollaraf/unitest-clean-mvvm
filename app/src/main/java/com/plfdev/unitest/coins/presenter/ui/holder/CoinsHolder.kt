package com.plfdev.unitest.coins.presenter.ui.holder

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
abstract class CoinsHolder : EpoxyModelWithHolder<CoinsHolder.MainCoinHolder>() {

    @EpoxyAttribute
    lateinit var title : String

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var coinClick: (ticker: String) -> Unit

    override fun bind(holder: MainCoinHolder){
        holder.viewBinding.apply {
            tickerCoin.text = title
            cardCoin.setOnClickListener {
                coinClick(title)
            }
        }
    }

    inner class MainCoinHolder : EpoxyHolder(){
        lateinit var viewBinding: HolderCoinBinding
        override fun bindView(itemView: View) {
            viewBinding = HolderCoinBinding.bind(itemView)
        }
    }
}