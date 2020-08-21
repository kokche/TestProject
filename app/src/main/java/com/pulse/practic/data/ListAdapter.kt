package com.pulse.practic.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pulse.practic.R
import com.pulse.practic.databinding.CardViewBinding
import com.pulse.practic.model.Tasks

class ListAdapter(private var items: List<Tasks>) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    inner class MyViewHolder(private var binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Tasks) {
            binding.tasks = task
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bingins = LayoutInflater.from(parent.context)
        return DataBindingUtil.inflate(bingins, R.layout.card_view,parent,false)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(items[position])

    }

    override fun getItemCount(): Int {
    return items.count()
    }


}