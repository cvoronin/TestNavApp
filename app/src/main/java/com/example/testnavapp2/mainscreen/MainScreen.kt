package com.example.testnavapp2.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testnavapp2.destinations.DetailScreenDestination
import com.example.testnavapp2.detailscreen.DetailScreenArgs
import com.example.testnavapp2.mainscreen.viewModel.MainScreenViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination(route = "mainScreen")
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
            .background(Color.Yellow)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = viewModel.createdAt)

        OutlinedTextField(
            value = viewModel.value,
            onValueChange = { viewModel.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextButton(
            onClick = {
                val args = DetailScreenArgs(viewModel.value, viewModel.createdAt)
                navigator.navigate(
                    DetailScreenDestination(args)
                )
            }) {
            Text(text = "Go!")
        }
    }
}