package com.pulse.practic.ui.activity.task.fragment.task

import androidx.lifecycle.ViewModel
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.data.repository.TaskRepository

abstract class TaskFragmentViewModel(): ViewModel() {

    abstract fun addTask(task: Task)
}