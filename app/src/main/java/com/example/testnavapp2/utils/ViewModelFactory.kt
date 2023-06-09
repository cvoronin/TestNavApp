package com.example.testnavapp2.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

interface SavedStateHandleViewModelFactory<T : ViewModel> {
    fun create(handle: SavedStateHandle): T
}

interface ComposeNavigationViewModelFactory<T : ViewModel> {
    fun create(handle: SavedStateHandle, destinationsNavigator: DestinationsNavigator): T
}

interface SimpleViewModelFactory<T : ViewModel> {
    fun create(): T
}

@Composable
inline fun <reified T : ViewModel> createSavedStateHandleViewModel(
    assistedFactory: SavedStateHandleViewModelFactory<T>
): T = viewModel {
    val savedStateHandle = createSavedStateHandle()
    assistedFactory.create(savedStateHandle)
}

@Composable
inline fun <reified T : ViewModel> createComposeNavigationViewModel(
    assistedFactory: ComposeNavigationViewModelFactory<T>,
    destinationsNavigator: DestinationsNavigator
): T = viewModel {
    val savedStateHandle = createSavedStateHandle()
    assistedFactory.create(savedStateHandle, destinationsNavigator)
}

@Composable
inline fun <reified T : ViewModel> createSimpleViewModel(
    factory: SimpleViewModelFactory<T>
): T = viewModel { factory.create() }