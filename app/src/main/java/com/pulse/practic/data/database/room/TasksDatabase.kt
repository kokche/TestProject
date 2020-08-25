package com.pulse.practic.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pulse.practic.data.database.room.dao.TasksDao
import com.pulse.practic.data.database.room.tabel.Task

@Database(entities = [Task::class], version = 2, exportSchema = false)
 abstract class TasksDatabase : RoomDatabase() {
      abstract fun tasksDao(): TasksDao
}