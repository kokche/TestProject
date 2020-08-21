package com.pulse.practic.ui.activity.task.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pulse.practic.App
import com.pulse.practic.R
import com.pulse.practic.data.ListAdapter
import com.pulse.practic.databinding.FragmentTasksBinding
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var binding:FragmentTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        recyclerView = binding.root.list_item
        viewManager = LinearLayoutManager(MainFragment().context)
        var items = App().database.tasksDao().getAll()
        viewAdapter = ListAdapter(items)
        floatingActionButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_to_tasksFragment))
    }
}