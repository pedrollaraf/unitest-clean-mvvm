package com.plfdev.unitest.coin.presenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.plfdev.unitest.R
import com.plfdev.unitest.coin.common.di.DIManager
import com.plfdev.unitest.coin.presenter.ui.controller.MainEpoxyController
import com.plfdev.unitest.databinding.ActivityMainBinding
import com.plfdev.unitest.coin.presenter.viewmodel.CoinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: CoinViewModel by viewModel()
    private var controller = MainEpoxyController()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    override fun onStart() {
        super.onStart()
        viewBinding.noContent.visibility = View.GONE
        viewBinding.progress.visibility = View.VISIBLE
        viewModel.getGetCoins()

        initEpoxy()
        initObservers()
        initListeners()
    }

    private fun initEpoxy(){
        viewBinding.recyclerView.apply {
            setController(controller)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initObservers(){
        viewModel.coins.observe(this) {
            if(it.isNotEmpty()){
                viewBinding.progress.visibility = View.GONE
                viewBinding.noContent.visibility = View.GONE
            }else{
                viewBinding.progress.visibility = View.GONE
                viewBinding.noContent.visibility = View.VISIBLE
            }
            controller.setData(it)
        }
    }

    private fun initDependencies(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            DIManager().initMealDependenceInjection(application)
        }
    }

    private fun initListeners(){
        viewBinding.clearButton.setOnClickListener(this)
        viewBinding.update.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.update -> {
                viewBinding.noContent.visibility = View.GONE
                viewBinding.progress.visibility = View.VISIBLE
                viewModel.getGetCoins()
            }
            R.id.clear_button -> {
                viewModel.clearList()
            }
        }
    }

}