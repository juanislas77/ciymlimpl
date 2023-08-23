package com.islas.mockktesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.islas.mockktesting.designsystem.components.SpaceCard
import com.islas.mockktesting.designsystem.theme.MockkTestingTheme
import com.islas.mockktesting.navigation.RootNavigationGraph
import com.islas.mockktesting.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainViewModel by viewModel<MainViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            MockkTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavigationGraph(navController = rememberNavController(), mainViewModel = mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    SpaceCard(modifier = modifier, title = name, imageUrl = null, date = "01-01-2005") {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MockkTestingTheme {
        Greeting("Android")
    }
}