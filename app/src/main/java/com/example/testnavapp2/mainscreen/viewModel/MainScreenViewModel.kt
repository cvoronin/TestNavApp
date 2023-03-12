package com.example.testnavapp2.mainscreen.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.testnavapp2.utils.SavedStateHandleViewModelFactory
import java.time.LocalTime
import javax.inject.Inject

class MainScreenViewModel constructor(
    private val handle: SavedStateHandle,
    private val dataConverter: DataConverter
) : ViewModel() {

    class Factory @Inject constructor(
        private val dataConverter: DataConverter
    ) : SavedStateHandleViewModelFactory<MainScreenViewModel> {

        override fun create(handle: SavedStateHandle): MainScreenViewModel =
            MainScreenViewModel(handle, dataConverter)
    }

    val createdAt: String = LocalTime.now().toString()

    var value by mutableStateOf("")
}



