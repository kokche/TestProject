package com.pulse.practic.di


import com.pulse.practic.data.database.room.TasksDatabase
import com.pulse.practic.data.repository.TaskRepository
import com.pulse.practic.data.repository.TaskRepositoryImpl
import org.koin.dsl.module

class RepositoryModule {
    companion object {
        val repositoryModule = module {
            single<TaskRepository> {
                TaskRepositoryImpl(
                    (get() as TasksDatabase).tasksDao()
                )
            }
        }
    }
}