package com.pulse.practic.ui.activity.task.fragment.main

import android.view.*
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.pulse.practic.R
import com.pulse.practic.ui.adapter.recycler.TaskAdapter
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.databinding.FragmentMainBinding
import com.pulse.practic.ui.base.BaseFragment
import com.pulse.practic.util.extension.showToast

import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoListFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val adapter by lazy { TaskAdapter(this::onLongTaskClick, this::onClickTask, this::onCheckBoxListener) }
    private val navController by lazy { findNavController() }
    private val viewModel by viewModel<ToDoViewModel>()

    override fun initUI() {
        initRecycler()
        initListener()
        viewModel.requestAll()
        observeData()
        setHasOptionsMenu(true);

    }

    override fun observeData() {
        viewModel.getTaskData().observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun initRecycler() {
        rv_items.adapter = adapter
    }

    private fun initListener() {
        floatingActionButton.setOnClickListener {
            startTaskFragment()
        }
    }

    private fun startTaskFragment() {
        navController.navigate(R.id.action_to_tasksFragment)
    }

    private fun onLongTaskClick(task: Task, position: Int) {
        showToast("Long")
    }

    private fun onClickTask(task: Task, position: Int) {
        showToast("click")
        navController.navigate(createDirections(task))
    }
    private fun onCheckBoxListener(task: Task){
        showToast("Update Task")
        viewModel.updateTask(task)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.to_do_list_all -> viewModel.requestAll()
            R.id.to_do_list_active -> viewModel.requestActive()
            R.id.to_do_list_completed -> viewModel.requestCompleted()
            R.id.to_do_list_clear_completed -> clearCompleted()
        }
        return true
    }

    private fun clearCompleted() {

    }

    private fun createDirections(task: Task): NavDirections =
        ToDoListFragmentDirections.actionMainFragmentToEditTaskFragment(task)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_task_menu, menu)
    }

}