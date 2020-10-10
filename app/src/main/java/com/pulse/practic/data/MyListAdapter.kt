package com.pulse.practic.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pulse.practic.R
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.databinding.CardViewBinding
import com.pulse.practic.util.diff_util.MyDiffUtil


class MyListAdapter() :
    ListAdapter<Task, MyListAdapter.MyViewHolder>(MyDiffUtil()) {


   inner class MyViewHolder(private var binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.tasks = task
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder = MyViewHolder(
        DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.card_view, parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(getItem(position))
}