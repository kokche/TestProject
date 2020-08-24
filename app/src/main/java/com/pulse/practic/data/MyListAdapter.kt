package com.pulse.practic.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pulse.practic.R
import com.pulse.practic.databinding.CardViewBinding
import com.pulse.practic.model.Tasks


class MyListAdapter() :
    ListAdapter<Tasks, MyListAdapter.MyViewHolder>(MyDiffUtil()) {

    private lateinit var listener:OnItemClickListener

   inner class MyViewHolder(private var binding: CardViewBinding,var listener:OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root), View.OnLongClickListener, View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }

        fun bind(task: Tasks) {
            binding.tasks = task
            binding.executePendingBindings()
        }

        override fun onLongClick(p0: View?): Boolean {
            if (listener != null){
                listener.setOnLongItemClickListener(getItem(adapterPosition),adapterPosition)
            }
            return true
        }

        override fun onClick(p0: View?) {
            if (listener != null){
                listener.setOnItemClickListener(getItem(adapterPosition),adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder = MyViewHolder(
        DataBindingUtil
            .inflate(LayoutInflater.from(parent.context), R.layout.card_view, parent, false)
    ,listener
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(getItem(position))


    interface OnItemClickListener{
        fun setOnItemClickListener(tasks: Tasks,position: Int)
        fun setOnLongItemClickListener(tasks: Tasks,position: Int)
    }
    fun setOnItemClickListener(Listener: OnItemClickListener){
        listener = Listener
    }
}