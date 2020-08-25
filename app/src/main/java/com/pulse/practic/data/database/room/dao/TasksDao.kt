package com.pulse.practic.data.database.room.dao

import androidx.room.*
import com.pulse.practic.data.database.room.tabel.Task

@Dao
interface TasksDao {

    @Query("Select * from task")
    fun getAll(): List<Task>

    @Query("Select * from task where task.isChecked = 0")
    fun getActive(): List<Task>

    @Query("Select * from task where task.isChecked = 1 ")
    fun getCompleted(): List<Task>

    @Insert
    fun addTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)

}