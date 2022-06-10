package com.plfdev.unitest.coin.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plfdev.unitest.coin.domain.usecases.abstraction.CoinUseCase

import kotlinx.coroutines.launch

class CoinViewModel(
    private val getCoinsUseCase : CoinUseCase
): ViewModel() {

    private val coinsMutableStateFlow = MutableLiveData<List<String>>()
    val coins : LiveData<List<String>> get() = coinsMutableStateFlow

    fun getGetCoins() {
        viewModelScope.launch {
            val coinList = getCoinsUseCase.getCoins()
            coinsMutableStateFlow.postValue(coinList)
        }
    }

    fun clearList(){
        coinsMutableStateFlow.postValue(listOf())
    }
}