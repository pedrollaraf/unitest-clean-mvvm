package com.plfdev.unitest.coins.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.plfdev.unitest.R
import com.plfdev.unitest.coins.presenter.ui.controller.CoinsEpoxyController
import com.plfdev.unitest.coins.presenter.viewmodel.CoinsViewModel
import com.plfdev.unitest.common.utils.MainActivity
import com.plfdev.unitest.databinding.FragmentCoinsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoinsFragment: Fragment(),View.OnClickListener, CoinsEpoxyController.CoinsClick{

    private var binding: FragmentCoinsBinding? = null
    private val viewBinding get() = binding!!

    private val coinsViewModel: CoinsViewModel by viewModel()
    private var controller = CoinsEpoxyController(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showHideProgressBar(true)
        coinsViewModel.getGetCoins()
        initObservables()
        initEpoxy()
        initListeners()
    }

    private fun initEpoxy(){
        viewBinding.recyclerView.apply {
            setController(controller)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initListeners(){
        (activity as MainActivity).getMainBinding().update.setOnClickListener(this)
    }

    private fun initObservables(){
        coinsViewModel.coins.observe(viewLifecycleOwner) {
            if(it.isNotEmpty()){
                (activity as MainActivity).showHideProgressBar(false)
                (activity as MainActivity).showHideSomethingWrong(false)
            }else{
                (activity as MainActivity).showHideProgressBar(false)
                (activity as MainActivity).showHideSomethingWrong(true)
            }
            controller.setData(it)
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.update -> {
                (activity as MainActivity).showHideProgressBar(true)
                (activity as MainActivity).showHideSomethingWrong(false)
                coinsViewModel.getGetCoins()
            }
        }
    }

    override fun onCoinClick(ticker: String) {
        findNavController().navigate(
            CoinsFragmentDirections.actionCoinsFragmentToStatisticsFragment(ticker)
        )
    }

}