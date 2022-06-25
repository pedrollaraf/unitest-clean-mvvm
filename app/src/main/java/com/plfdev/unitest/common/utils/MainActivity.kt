package com.plfdev.unitest.common.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.plfdev.unitest.common.di.DIManager
import com.plfdev.unitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    private fun initDependencies(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            DIManager().initMealDependenceInjection(application)
        }
    }

    fun showHideProgressBar(visibility: Boolean) {
        when {
            visibility -> {
                viewBinding.progress.visibility = View.VISIBLE
                viewBinding.root.alpha = 0.2f
                Screen.enableDisableView(this, false)
            }
            else -> {
                viewBinding.progress.visibility = View.GONE
                viewBinding.root.alpha = 1f
                Screen.enableDisableView(this, true)
            }
        }
    }

    fun showHideSomethingWrong(visibility: Boolean){
        when {
            visibility -> {
                viewBinding.somethingWrong.visibility = View.VISIBLE
            }
            else -> {
                viewBinding.somethingWrong.visibility = View.GONE
            }
        }
    }

    fun getMainBinding(): ActivityMainBinding {
        return viewBinding
    }




    /*private fun initListeners(){
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
    }*/

}