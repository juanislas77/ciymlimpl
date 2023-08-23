package com.islas.mockktesting.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.SubcomposeAsyncImage
import com.islas.mockktesting.R

@Composable
fun LaunchDetailView(
    mainViewModel: MainViewModel
) {
    val launchItem = mainViewModel.let {
        it.getItemLaunch(it.getId())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(262.dp),
                painter = painterResource(id = R.drawable.background_default),
                contentDescription = "Background image"
            )
            Row(
                modifier = Modifier.padding(
                    horizontal = 10.dp,
                    vertical = 30.dp
                )
            ) {
                if (launchItem.logoLaunched.isBlank()) {
                    Image(
                        modifier = Modifier
                            .size(92.dp),
                        painter = painterResource(id = R.drawable.patch_default),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Launch Patch"
                    )
                } else {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(92.dp),
                        model = launchItem.logoLaunched,
                        contentScale = ContentScale.Crop,
                        contentDescription = "Launch Patch"
                    )
                }
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = launchItem.nameLaunched,
                        fontWeight = FontWeight.Medium,
                        fontSize = 26.sp,
                        color = Color.White
                    )
                    Text(
                        text = launchItem.dateLaunchedLocal,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
        Text(
            text = "Description",
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp
        )
        val context = LocalContext.current
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(launchItem.article))
//        Text(
//            text = launchItem.article,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .clickable {
//                           startActivity(context, intent, null)
//                },
//            textAlign = TextAlign.Right,
//            fontSize = 12.sp
//        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    startActivity(context, intent, null)
                }) {
                Text(text = "Article")
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 200.dp)
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Text(
                text = launchItem.description,
                modifier = Modifier.padding(10.dp)
            )
        }
        if (launchItem.original.isNotEmpty()) {
            LazyRow {
                items(launchItem.original) {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(262.dp)
                            .padding(
                                horizontal = 8.dp,
                                vertical = 16.dp
                            ),
                        model = it,
                        contentScale = ContentScale.Crop,
                        contentDescription = "Launch Patch"
                    )
                }
            }
        } else {
            Text(
                text = "No media available",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 20.dp
                    ),
                textAlign = TextAlign.Center
            )
        }
    }
}
