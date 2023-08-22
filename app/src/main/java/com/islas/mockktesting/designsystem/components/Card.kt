package com.islas.mockktesting.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.islas.mockktesting.R

@Composable
fun SpaceCard(
    modifier: Modifier,
    title: String,
    imageUrl: String?,
    date: String,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onCardClick.invoke() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            imageUrl?.let {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    model = it,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Launch Patch"
                )
            }?: Image(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.patch_default),
                contentScale = ContentScale.Crop,
                contentDescription = "Launch Patch"
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(.66f)
                    .padding(1.dp)
            ) {
                Text(text = title)
                Text(text = date)
            }
        }
    }
}