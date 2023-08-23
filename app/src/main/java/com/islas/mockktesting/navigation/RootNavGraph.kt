package com.islas.mockktesting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.islas.mockktesting.navigation.graphs.Graph
import com.islas.mockktesting.presentation.LaunchDetailView
import com.islas.mockktesting.presentation.LaunchListView
import com.islas.mockktesting.presentation.MainViewModel

@Composable
fun RootNavigationGraph(navController: NavHostController, mainViewModel: MainViewModel) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.LIST
    ) {
        composable(route = Graph.LIST) {
            LaunchListView(viewModel = mainViewModel, navController)
        }
        composable(
            route = Graph.DETAIL + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = "Default"
                }
            )
        ){
            LaunchDetailView(mainViewModel)
        }
    }
}
