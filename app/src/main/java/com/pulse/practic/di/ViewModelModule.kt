package com.pulse.practic.di

import com.pulse.practic.ui.activity.task.fragment.edit.EditTaskViewModel
import com.pulse.practic.ui.activity.task.fragment.edit.EditTaskViewModelImpl
import com.pulse.practic.ui.activity.task.fragment.main.ToDoVieModelIml
import com.pulse.practic.ui.activity.task.fragment.main.ToDoViewModel
import com.pulse.practic.ui.activity.task.fragment.task.TaskFragmentViewModel
import com.pulse.practic.ui.activity.task.fragment.task.TaskFragmentViewModelIml
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {
    companion object {
        val viewModelModule = module {
            viewModel<EditTaskViewModel> { EditTaskViewModelImpl(get()) }
            viewModel<ToDoViewModel> { ToDoVieModelIml(get()) }
            viewModel<TaskFragmentViewModel> { TaskFragmentViewModelIml(get()) }

        }
    }
}