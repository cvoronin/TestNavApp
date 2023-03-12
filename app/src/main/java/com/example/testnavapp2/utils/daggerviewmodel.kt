package com.example.testnavapp2.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: () -> T
): T =
    viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelInstanceCreator() as T
            }
        }
    )

@Composable
inline fun <reified T : ViewModel> daggerViewModel2(
    factory: ViewModelProvider.Factory,
    key: String? = null,
): T =
    viewModel(
        modelClass = T::class.java,
        key = key,
        factory = factory
    )

@Composable
inline fun <reified T : ViewModel> daggerViewModelFactory(
    key: String? = null,
    crossinline viewModelInstanceCreator: () -> T
): T =
    viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelInstanceCreator() as T
            }
        }
    )

//@Composable
//inline fun <reified VM : ViewModel> daggerViewModel(): VM {
//    return viewModel {
//        val savedStateHandle = createSavedStateHandle()
//        factory.create(VM::class.java, savedStateHandle)
//    }
//}