package com.pulse.practic

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pulse.practic.data.TasksDatabase


class App : Application(){
   companion object {
       lateinit var instance: App

       private val MIGRATION_1_2 = object : Migration(1, 2) {
           override fun migrate(database: SupportSQLiteDatabase) {
               database.execSQL("ALTER TABLE tasks ADD COLUMN isChecked BOOLEAN default false");
           }
       }

   }
    val database by lazy {
        Room.databaseBuilder<TasksDatabase>(this, TasksDatabase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }



    override fun onCreate() {
        super.onCreate()
        instance = this
        database
    }
}