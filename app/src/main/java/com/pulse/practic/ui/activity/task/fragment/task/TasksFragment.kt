package com.pulse.practic.ui.activity.task.fragment.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import com.pulse.practic.App
import com.pulse.practic.R
import com.pulse.practic.databinding.FragmentTasksBinding
import com.pulse.practic.model.Tasks
import kotlinx.android.synthetic.main.fragment_tasks.*


class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding

    private val showTexPanel by lazy {
        (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        edit_text.requestFocus()
        showTexPanel.showSoftInput(edit_text, InputMethodManager.SHOW_IMPLICIT)
        floatingActionButton.setOnClickListener {
            if (edit_text.text.toString().isNotEmpty()){
                showTexPanel.hideSoftInputFromWindow(edit_text.windowToken,0)
                App.instance.database.tasksDao().addTask(Tasks(0,edit_text.text.toString()))
                //Toast.makeText(TasksFragment().context, "TO-DO added", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(edit_text).popBackStack()
            }
        }
    }

}