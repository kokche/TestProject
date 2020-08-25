package com.pulse.practic.ui.activity.task

import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pulse.practic.R
import com.pulse.practic.databinding.ActivityMainBinding
import com.pulse.practic.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(layoutId = R.layout.activity_main) {

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun initUI() {
        initNavComponent()
        initListeners()
    }

    private fun initNavComponent() {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun initListeners() {

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> navController.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}