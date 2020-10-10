package com.pulse.practic.util.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pulse.practic.data.MyListAdapter
import com.pulse.practic.data.database.room.tabel.Task

@BindingAdapter("items")
fun setRecyclerViewItems(recyclerView: RecyclerView, list: List<Task>?){
    var adapter = (recyclerView.adapter as? MyListAdapter)
    if (adapter == null) {
        adapter = MyListAdapter()
        recyclerView.adapter = adapter
    }
    list?.let { adapter.submitList(it) }
}