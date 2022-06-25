package com.plfdev.unitest.coins.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plfdev.unitest.coins.domain.usecases.abstraction.CoinUseCase

import kotlinx.coroutines.launch

class CoinsViewModel(
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
        coinsMutableStateFlow.value = listOf()
    }
}