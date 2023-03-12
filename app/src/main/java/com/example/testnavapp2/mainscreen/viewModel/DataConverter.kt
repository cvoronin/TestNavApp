package com.example.testnavapp2.mainscreen.viewModel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataConverter @Inject constructor() {
    fun convert(value: String): String = value
}