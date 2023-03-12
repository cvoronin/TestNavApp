package com.example.testnavapp2.detailscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.testnavapp2.destinations.MainScreenDestination
import com.example.testnavapp2.mainscreen.viewModel.DataConverter
import com.example.testnavapp2.navArgs
import com.example.testnavapp2.utils.ComposeNavigationViewModelFactory
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.LocalTime
import javax.inject.Inject

class DetailScreenViewModel(
    private val savedStateHandle: SavedStateHandle, // assisted
    private val destinationsNavigator: DestinationsNavigator, // assisted
    private val dataConverter: DataConverter // injected
) : ViewModel() {

    class Factory @Inject constructor(
        private val dataConverter: DataConverter
    ) : ComposeNavigationViewModelFactory<DetailScreenViewModel> {
        override fun create(
            handle: SavedStateHandle,
            destinationsNavigator: DestinationsNavigator
        ): DetailScreenViewModel =
            DetailScreenViewModel(handle, destinationsNavigator, dataConverter)
    }

    val createdAt: String = LocalTime.now().toString()

    val args = navArgs(DetailScreenArgs::class.java, savedStateHandle)

    val convertedEnteredValue = dataConverter.convert(args.enteredValue)

    fun showMainScreen() = destinationsNavigator.navigate(MainScreenDestination)
}