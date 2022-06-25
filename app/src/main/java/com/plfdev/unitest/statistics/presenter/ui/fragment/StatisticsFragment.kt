package com.plfdev.unitest.statistics.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.plfdev.unitest.common.utils.MainActivity
import com.plfdev.unitest.databinding.FragmentCoinsBinding
import com.plfdev.unitest.databinding.FragmentStatisticsBinding

class StatisticsFragment: Fragment() {

    private var binding: FragmentStatisticsBinding? = null
    private val viewBinding get() = binding!!

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
        (activity as MainActivity).showHideSomethingWrong(true)
        //statisticsViewModel.getAllStatistics()
        /*initObservables()
        initEpoxy()
        initListeners()*/
    }

}