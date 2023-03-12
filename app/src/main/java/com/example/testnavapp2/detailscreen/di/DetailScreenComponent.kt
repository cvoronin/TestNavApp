package com.example.testnavapp2.detailscreen.di

import com.example.testnavapp2.detailscreen.DetailScreenViewModel
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DetailScreenScope

@Subcomponent
@DetailScreenScope
interface DetailScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailScreenComponent
    }

    fun detailScreenViewModelFactory(): DetailScreenViewModel.Factory
}
