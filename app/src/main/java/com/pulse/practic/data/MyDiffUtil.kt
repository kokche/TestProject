package com.pulse.practic.data

import androidx.recyclerview.widget.DiffUtil
import com.pulse.practic.model.Tasks

class MyDiffUtil : DiffUtil.ItemCallback<Tasks>() {

    override fun areItemsTheSame(oldItem: Tasks, newItem: Tasks): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Tasks, newItem: Tasks): Boolean =
        oldItem == newItem
}