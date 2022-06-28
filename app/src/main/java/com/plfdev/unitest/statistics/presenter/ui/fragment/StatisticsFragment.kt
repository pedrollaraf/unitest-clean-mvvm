package com.plfdev.unitest.statistics.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.plfdev.unitest.coins.presenter.viewmodel.CoinsViewModel
import com.plfdev.unitest.common.utils.MainActivity
import com.plfdev.unitest.databinding.FragmentCoinsBinding
import com.plfdev.unitest.databinding.FragmentStatisticsBinding
import com.plfdev.unitest.statistics.presenter.viewmodel.StatisticsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatisticsFragment: Fragment() {

    private var binding: FragmentStatisticsBinding? = null
    private val viewBinding get() = binding!!

    private val statisticsViewModel: StatisticsViewModel by viewModel()
    private val statisticsArgs: StatisticsFragmentArgs by navArgs()

    private var tickerCoin: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showHideProgressBar(true)
        getArgs()
        statisticsViewModel.getStatistics(tickerCoin)
        //statisticsViewModel.getAllStatistics()
        /*initObservables()
        initEpoxy()
        initListeners()*/
    }

    private fun getArgs(){
        tickerCoin = if(!statisticsArgs.ticker.isNullOrEmpty()) statisticsArgs.ticker!! else ""
    }

}