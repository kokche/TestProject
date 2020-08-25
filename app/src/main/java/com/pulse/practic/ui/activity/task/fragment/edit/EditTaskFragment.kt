package com.pulse.practic.ui.activity.task.fragment.edit

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pulse.practic.App
import com.pulse.practic.R
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.databinding.FragmentEditTaskBinding
import com.pulse.practic.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_edit_task.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditTaskFragment : BaseFragment<FragmentEditTaskBinding>(R.layout.fragment_edit_task) {

    private val showTexPanel by lazy {
        (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
    }
    private val navController by lazy { findNavController() }
    private val viewModel by viewModel<EditTaskViewModel>()
    private val navArgs: EditTaskFragmentArgs by navArgs()


    override fun initUI() {
        etName.requestFocus()
        initBinding()
        initListeners()
        setHasOptionsMenu(true)
    }

    private fun initBinding() {
        binding.task = navArgs.itemTask
    }

    override fun initListeners() {
        floatingActionButton.setOnClickListener {
            if (!etName.isEnabled) {
                etName.isEnabled = true
                showTexPanel.showSoftInput(etName, InputMethodManager.SHOW_IMPLICIT)
                floatingActionButton.setImageResource(R.drawable.ic_baseline_done_24)
            } else {
                etName.isEnabled = false
                showTexPanel.hideSoftInputFromWindow(etName.windowToken, 0)
                floatingActionButton.setImageResource(R.drawable.ic_baseline_edit_24)
                navArgs.itemTask.name = etName.text.toString()
                updateTask(navArgs.itemTask)
            }
        }
    }

    private fun updateTask(task: Task) {
        viewModel.updateTask(task)
    }

    private fun deleteTask(task: Task) {
        viewModel.deleteTask(task)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_tasks_delete -> {
                deleteTask(navArgs.itemTask)
                navController.popBackStack()
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edite_tasks_menu, menu)
    }
}