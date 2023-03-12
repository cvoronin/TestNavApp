package com.example.testnavapp2

import android.app.Application
import com.example.testnavapp2.di.AppComponent
import com.example.testnavapp2.di.AppComponentProvider
import com.example.testnavapp2.di.DaggerAppComponent

class TestNavApplication : Application(), AppComponentProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    override fun appComponent(): AppComponent = appComponent
}