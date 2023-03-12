package com.example.testnavapp2.mainscreen.di

import com.example.testnavapp2.mainscreen.viewModel.MainScreenViewModel
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScreenScope

@MainScreenScope
@Subcomponent(modules = [MainScreenModule::class])
interface MainScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainScreenComponent
    }

    fun mainScreenViewModelFactory(): MainScreenViewModel.Factory
}