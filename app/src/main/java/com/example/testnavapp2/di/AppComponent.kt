package com.example.testnavapp2.di

import com.example.testnavapp2.detailscreen.di.DetailScreenComponent
import com.example.testnavapp2.mainscreen.di.MainScreenComponent
import dagger.Component
import javax.inject.Singleton


@Component
@Singleton
interface AppComponent {
    fun mainScreenComponent(): MainScreenComponent.Factory
    fun detailsScreenComponent(): DetailScreenComponent.Factory
}

interface AppComponentProvider {
    fun appComponent(): AppComponent
}
