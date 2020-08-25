package com.pulse.practic.ui.activity.task.fragment.edit

import androidx.lifecycle.ViewModel
import com.pulse.practic.data.database.room.tabel.Task

abstract class EditTaskViewModel: ViewModel() {

    abstract fun updateTask(task: Task)
    abstract fun deleteTask(task: Task)
}