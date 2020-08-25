package com.pulse.practic

import android.app.Application
import com.pulse.practic.di.AppModule
import com.pulse.practic.di.NetworkModule
import com.pulse.practic.di.RepositoryModule
import com.pulse.practic.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module


class App : Application(){
   companion object {
       lateinit var instance: App

   }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            module {
                androidLogger(Level.ERROR)
                androidContext(this@App)
                modules(
                    listOf(
                        AppModule.dataModule,
                        NetworkModule.networkModule,
                        ViewModelModule.viewModelModule,
                        RepositoryModule.repositoryModule
                    )
                )
            }
        }
    }
}