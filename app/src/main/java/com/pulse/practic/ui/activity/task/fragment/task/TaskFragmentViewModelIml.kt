package com.pulse.practic.ui.activity.task.fragment.task

import androidx.lifecycle.viewModelScope
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskFragmentViewModelIml(
    private val taskRepository: TaskRepository
): TaskFragmentViewModel() {

    override fun addTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.addTask(task)
        }

    }


}