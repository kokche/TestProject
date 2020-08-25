package com.pulse.practic.ui.activity.task.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pulse.practic.data.database.room.tabel.Task

abstract class ToDoViewModel : ViewModel(){

    abstract fun requestAll()
    abstract fun getTaskData():LiveData<List<Task>>
    abstract fun deleteTask(task: Task)
    abstract fun updateTask(task: Task)
    abstract fun requestActive()
    abstract fun requestCompleted()
}