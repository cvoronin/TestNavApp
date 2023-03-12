package com.example.testnavapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testnavapp2.detailscreen.DetailScreen
import com.example.testnavapp2.di.AppComponentProvider
import com.example.testnavapp2.mainscreen.MainScreen
import com.example.testnavapp2.ui.theme.MyAppTheme
import com.example.testnavapp2.utils.createSavedStateHandleViewModel
import com.example.testnavapp2.utils.createSimpleViewModel

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
                    val navController = rememberNavController()

                    WindowInsets.statusBars
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddings)
                    ) {
                        composable("main") {

                            val assistedFactory = mainScreenComponent.mainScreenViewModelFactory()
                            val viewModel = createSavedStateHandleViewModel(assistedFactory)

                            MainScreen(
                                viewModel = viewModel,
                                onValueEntered = { navController.navigate("detail") }
                            )
                        }
                        composable("detail") {

                            val viewModel = createSimpleViewModel(
                                factory = detailScreenComponent.detailScreenViewModelFactory()
                            )

                            DetailScreen(
                                viewModel = viewModel,
                                onGoToMainScreen = { navController.navigate("main") }
                            )
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

