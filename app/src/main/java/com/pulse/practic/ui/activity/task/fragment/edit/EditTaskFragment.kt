package com.pulse.practic.ui.activity.task.fragment.edit

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.navArgs
import com.pulse.practic.App
import com.pulse.practic.R
import com.pulse.practic.databinding.FragmentEditTaskBinding
import kotlinx.android.synthetic.main.fragment_edit_task.edit_text
import kotlinx.android.synthetic.main.fragment_edit_task.floatingActionButton

class EditTaskFragment : Fragment() {

    private val showTexPanel by lazy {
        (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
    }

    private val args: EditTaskFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  FragmentEditTaskBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        var itemTask = args.itemTask
        edit_text.text.append(itemTask.name)
        edit_text.setTextColor(Color.BLACK)
        floatingActionButton.setOnClickListener {
            if (!edit_text.isEnabled) {
                edit_text.isEnabled = true
                showTexPanel.showSoftInput(edit_text, InputMethodManager.SHOW_IMPLICIT)
                floatingActionButton.setImageResource(R.drawable.ic_baseline_done_24)
            }else{
                edit_text.isEnabled = false
                itemTask.name = edit_text.text.toString()
                showTexPanel.hideSoftInputFromWindow(edit_text.windowToken,0)
                floatingActionButton.setImageResource(R.drawable.ic_baseline_edit_24)
                App.instance.database.tasksDao().updateTask(itemTask)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edite_tasks_menu, menu)
    }
}