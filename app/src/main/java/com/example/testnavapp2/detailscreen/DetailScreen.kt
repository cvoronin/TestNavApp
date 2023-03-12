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
import com.example.testnavapp2.destinations.DetailScreenDestination
import com.example.testnavapp2.destinations.MainScreenDestination
import com.example.testnavapp2.navArgs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

data class DetailScreenArgs(
    val enteredValue: String,
    val mainScreenCreatedAt: String
)

@Destination(
    route = "detailScreen",
    navArgsDelegate = DetailScreenArgs::class
)
@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Text(text = "Created at: ${viewModel.createdAt}")

            Text(text = "Converted Entered value: ${viewModel.convertedEnteredValue}")

            TextButton(onClick = { viewModel.showMainScreen() } ) {
                Text("Go to MainScreen")
            }
        }
    }
}