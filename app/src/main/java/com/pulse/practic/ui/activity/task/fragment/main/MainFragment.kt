package com.pulse.practic.ui.activity.task.fragment.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.pulse.practic.App
import com.pulse.practic.R
import com.pulse.practic.data.MyListAdapter
import com.pulse.practic.databinding.FragmentMainBinding
import com.pulse.practic.model.Tasks
import com.pulse.practic.utils.showToast
import kotlinx.android.synthetic.main.fragment_edit_task.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.floatingActionButton

class MainFragment : Fragment() {

    private val myDatabase by lazy { App.instance.database.tasksDao() }
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val adapter = MyListAdapter()
        rv_items.adapter = adapter
        adapter.submitList(myDatabase.getAll())
        adapter.setOnItemClickListener(object : MyListAdapter.OnItemClickListener {
            override fun setOnItemClickListener(tasks: Tasks, position: Int) {
                val directions = MainFragmentDirections
                    .actionMainFragmentToEditTaskFragment(tasks)
                Navigation.findNavController(rv_items).navigate(directions)

            }

            override fun setOnLongItemClickListener(tasks: Tasks, position: Int) {
                showToast("long")
            }
        })

        floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_to_tasksFragment))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

    }
}