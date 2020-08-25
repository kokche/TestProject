package com.pulse.practic.util.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.pulse.practic.data.database.room.tabel.Task

class MyDiffUtil : DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem == newItem
}