package com.pulse.practic.ui.activity.task

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pulse.practic.R
import com.pulse.practic.databinding.ActivityMainBinding

class TaskActivity : AppCompatActivity() {


    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> navController.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }


}