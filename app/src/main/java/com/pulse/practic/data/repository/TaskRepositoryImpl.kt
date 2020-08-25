package com.pulse.practic.data.repository

import com.pulse.practic.App
import com.pulse.practic.data.database.room.dao.TasksDao
import com.pulse.practic.data.database.room.tabel.Task

class TaskRepositoryImpl(
    private val taskDao: TasksDao
) : TaskRepository {
    override suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }
    override suspend fun getAllTask() = taskDao.getAll()
    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    override suspend fun completedTask(): List<Task> = taskDao.getCompleted()


    override suspend fun activeTask(): List<Task> = taskDao.getActive()


}