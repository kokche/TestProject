package com.pulse.practic.data.repository

import com.pulse.practic.data.database.room.tabel.Task

interface TaskRepository {

    suspend fun addTask(task: Task)
    suspend fun getAllTask(): List<Task>
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun completedTask():List<Task>
    suspend fun activeTask():List<Task>

}