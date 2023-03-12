package com.example.testnavapp2

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testnavapp2.destinations.DetailScreenDestination
import com.example.testnavapp2.destinations.MainScreenDestination
import com.example.testnavapp2.detailscreen.DetailScreen
import com.example.testnavapp2.di.AppComponentProvider
import com.example.testnavapp2.mainscreen.MainScreen
import com.example.testnavapp2.ui.theme.MyAppTheme
import com.example.testnavapp2.utils.createComposeNavigationViewModel
import com.example.testnavapp2.utils.createSavedStateHandleViewModel
import com.example.testnavapp2.utils.createSimpleViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this.applicationContext
        val appComponentProvider = context as AppComponentProvider
        val appComponent = appComponentProvider.appComponent()
        val mainScreenComponent = appComponent.mainScreenComponent().create()
        val detailScreenComponent = appComponent.detailsScreenComponent().create()

        setContent {
            MyAppTheme {
                Scaffold { paddings ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddings)
                    )
                    {
                        WindowInsets.statusBars
                        DestinationsNavHost(navGraph = NavGraphs.root) {
                            composable(MainScreenDestination) {
                                val assistedFactory =
                                    mainScreenComponent.mainScreenViewModelFactory()
                                val viewModel = createSavedStateHandleViewModel(assistedFactory)

                                MainScreen(
                                    viewModel = viewModel,
                                    navigator = destinationsNavigator
                                )
                            }

                            composable(DetailScreenDestination) {
                                val assistedFactory =
                                    detailScreenComponent.detailScreenViewModelFactory()

                                val viewModel = createComposeNavigationViewModel(
                                    assistedFactory,
                                    destinationsNavigator
                                )

                                DetailScreen(viewModel = viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        Greeting("Android")
    }
}

