package com.pulse.practic.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pulse.practic.R
import com.pulse.practic.databinding.CardViewBinding
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.util.diff_util.MyDiffUtil


class TaskAdapter(
    private val onLogClick: (Task, Int) -> Unit,
    private val onClick: (Task, Int) -> Unit,
    private val onCheckBoxClick: (Task) -> Unit

) :
    ListAdapter<Task, TaskAdapter.MyViewHolder>(MyDiffUtil()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder = MyViewHolder(
        DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.card_view, parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class MyViewHolder(private var binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task, position: Int) {

            binding.tasks = task
            binding.executePendingBindings()

            iniListeners(task, position)
        }

        private fun iniListeners(task: Task, position: Int) {

            binding.root.setOnClickListener {
                onClick(task, position)
            }
            binding.root.setOnLongClickListener {
                onLogClick(task, position)
                return@setOnLongClickListener true
            }
            binding.checkbox.setOnClickListener {
                onCheckBoxClick(task)
            }
        }

    }

}