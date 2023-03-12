package com.example.testnavapp2.detailscreen

import androidx.lifecycle.ViewModel
import com.example.testnavapp2.mainscreen.viewModel.DataConverter
import com.example.testnavapp2.utils.SimpleViewModelFactory
import java.time.LocalTime
import javax.inject.Inject

class DetailScreenViewModel(
    private val dataConverter: DataConverter
): ViewModel() {

    class Factory @Inject constructor(
        private val dataConverter: DataConverter
    ): SimpleViewModelFactory<DetailScreenViewModel> {
        override fun create(): DetailScreenViewModel = DetailScreenViewModel(dataConverter)
    }

    val createdAt: String = LocalTime.now().toString()

}