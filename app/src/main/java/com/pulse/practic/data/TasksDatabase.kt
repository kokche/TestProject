package com.pulse.practic.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TasksDatabase::class], version = 1)
abstract class TasksDatabase : RoomDatabase() {
      abstract fun tasksDao():TasksDao
}