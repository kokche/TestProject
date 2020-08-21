package com.pulse.practic.data

import androidx.room.*
import com.pulse.practic.model.Tasks

@Dao
interface TasksDao {
    @Query("Select * from tasks")
    fun getAll(): List<Tasks>

    @Insert
    fun addTask(task: Tasks)

    @Delete
    fun deleteTask(task: Tasks)

    @Update
    fun updateTask(task: Tasks)

}