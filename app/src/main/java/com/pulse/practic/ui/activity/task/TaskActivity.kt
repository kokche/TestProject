package com.pulse.practic.ui.activity.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pulse.practic.R
import com.pulse.practic.databinding.ActivityMainBinding

class TaskActivity : AppCompatActivity() {


    val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

}