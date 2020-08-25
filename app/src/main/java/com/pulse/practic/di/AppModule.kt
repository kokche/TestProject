package com.pulse.practic.di

import androidx.room.Room
import com.pulse.practic.data.database.room.TasksDatabase
import com.pulse.practic.data.database.room.migration.MIGRATION_1_2
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

class AppModule {
    companion object {
        val dataModule = module {
            single {
                Room.databaseBuilder(androidApplication(), TasksDatabase::class.java, "database")
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }

        }
    }
}