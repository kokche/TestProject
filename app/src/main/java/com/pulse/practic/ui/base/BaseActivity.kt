package com.pulse.practic.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<V : ViewBinding>(
    private val layoutId: Int
) : AppCompatActivity() {

    lateinit var binding: V

    abstract fun initUI()
    abstract fun initListeners()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        initUI()
    }


}