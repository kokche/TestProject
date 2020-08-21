package com.pulse.practic.ui.activity.task.fragment.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pulse.practic.R
import com.pulse.practic.databinding.FragmentTasksBinding


class tasksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var binding = FragmentTasksBinding.inflate(inflater,container,false)
        return binding.root
    }

}