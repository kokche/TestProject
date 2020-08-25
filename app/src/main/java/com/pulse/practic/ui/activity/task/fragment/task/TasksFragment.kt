package com.pulse.practic.ui.activity.task.fragment.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.pulse.practic.App
import com.pulse.practic.R
import com.pulse.practic.databinding.FragmentTasksBinding
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tasks.*
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TasksFragment : BaseFragment<FragmentTasksBinding>(R.layout.fragment_tasks){

    private val navController by lazy {
        findNavController()
    }
    private val viewModel by viewModel<TaskFragmentViewModel>()

    private val showTexPanel by lazy {
        (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
    }

    override fun initUI() {
        setHasOptionsMenu(true);
        requestFocusOnEditText()

    }

    override fun initListeners() {
        floatingActionButton.setOnClickListener {
            createTask()
        }
    }

    private fun createTask() {
        if (etName.text.toString().isNotEmpty()) {
            showTexPanel.hideSoftInputFromWindow(etName.windowToken, 0)
            addTask(etName.text.toString())
            navController.popBackStack()
        }
    }

    private fun requestFocusOnEditText() {
        etName.requestFocus()
        showTexPanel.showSoftInput(etName, InputMethodManager.SHOW_IMPLICIT)
    }


    private fun addTask(name:String){
        viewModel.addTask(Task(name))
    }


}