package com.pulse.practic.data

import androidx.recyclerview.widget.DiffUtil
import com.pulse.practic.model.Tasks

class MyDiffUtil(var oldItems: List<Tasks>, var newItems: List<Tasks>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldListSize

    override fun getNewListSize(): Int = newListSize

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].id == newItems[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}