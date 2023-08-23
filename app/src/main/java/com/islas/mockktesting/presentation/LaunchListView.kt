package com.islas.mockktesting.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.islas.mockktesting.designsystem.components.SpaceCard
import com.islas.mockktesting.navigation.graphs.Graph

@Composable
fun LaunchListView(
    viewModel: MainViewModel,
    navController: NavHostController
) {
    LaunchedEffect(true) {
        viewModel.getLaunchesList()
    }

    if (viewModel.result.isNotEmpty()) {
        LazyColumn {
            items(viewModel.result.toList()) { launchItem ->
                SpaceCard(
                    modifier = Modifier.padding(4.dp),
                    title = launchItem.nameLaunched,
                    imageUrl = launchItem.logoLaunched,
                    date = launchItem.dateLaunchedLocal,
                    onCardClick = {
                        viewModel.setId(launchItem.id)
                        navController.navigate(Graph.DETAIL + "/${launchItem.id}")
                    }
                )
            }
        }
    } else{
        Text(text = "Empty list")
    }
//    LazyColumn{
//        item(viewModel.result){ launchItem ->
//            SpaceCard(modifier = Modifier, title = , imageUrl = , date = ) {
//
//            }
//        }
//    }
}