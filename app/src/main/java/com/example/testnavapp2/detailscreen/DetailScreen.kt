package com.example.testnavapp2.detailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    onGoToMainScreen: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Text(text = "Created at: ${viewModel.createdAt}")

            Text(text = "Entered value: value")

            TextButton(onClick = onGoToMainScreen) {
                Text("Go to MainScreen")
            }
        }
    }
}