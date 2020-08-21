package com.pulse.practic

import android.app.Application
import androidx.room.Room
import com.pulse.practic.data.TasksDatabase


class App() : Application(){
    val instance: App by lazy { this }
    val database: TasksDatabase by  lazy {
        Room.databaseBuilder<TasksDatabase>(this, TasksDatabase::class.java, "database")
            .build()
    }
}