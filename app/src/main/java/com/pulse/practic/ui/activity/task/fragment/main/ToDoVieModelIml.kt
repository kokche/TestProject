package com.pulse.practic.ui.activity.task.fragment.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pulse.practic.data.database.room.tabel.Task
import com.pulse.practic.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoVieModelIml(
    private val taskRepository: TaskRepository
) : ToDoViewModel() {

    private val taskData = MutableLiveData<List<Task>>()

    override fun requestAll() {
        viewModelScope.launch {
            taskData.value = withContext(Dispatchers.IO) {
                taskRepository.getAllTask()
            }
        }
    }
    override fun requestActive() {
        viewModelScope.launch {
            taskData.value = withContext(Dispatchers.IO) {
                taskRepository.activeTask()
            }
        }
    }
    override fun requestCompleted() {
        viewModelScope.launch {
            taskData.value = withContext(Dispatchers.IO) {
                taskRepository.completedTask()
            }
        }
    }

    override fun getTaskData() = taskData

    override fun deleteTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.deleteTask(task)
        }
    }

    override fun updateTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.updateTask(task)
        }
    }


}