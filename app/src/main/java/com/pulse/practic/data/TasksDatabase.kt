package com.pulse.practic.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pulse.practic.model.Tasks

@Database(entities = [Tasks::class], version = 2, exportSchema = false)
 abstract class TasksDatabase : RoomDatabase() {
      abstract fun tasksDao():TasksDao
}