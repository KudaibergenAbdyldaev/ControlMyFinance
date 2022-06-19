package com.example.controlmyfinance.presentation

import android.app.Application
import com.example.controlmyfinance.di.localDBModel
import com.example.controlmyfinance.di.mapperModule
import com.example.controlmyfinance.di.repositoryModule
import com.example.controlmyfinance.di.viewModelModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(repositoryModule)
            modules(mapperModule)
            modules(viewModelModule)
            modules(localDBModel)
        }
    }

}