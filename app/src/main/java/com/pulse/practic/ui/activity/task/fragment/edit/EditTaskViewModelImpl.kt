package com.pulse.practic.ui.activity.task.fragment.edit

import androidx.lifecycle.viewModelScope
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditTaskViewModelImpl(
    private val taskRepository: TaskRepository
) : EditTaskViewModel() {
    override fun updateTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.updateTask(task)
        }
    }

    override fun deleteTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.deleteTask(task)
        }
    }
}
