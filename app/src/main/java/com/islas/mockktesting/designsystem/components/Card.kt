package com.islas.mockktesting.designsystem.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.islas.mockktesting.R
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
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
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (imageUrl.isNullOrBlank()) {
                Image(
                    modifier = Modifier
                        .size(92.dp),
                    painter = painterResource(id = R.drawable.patch_default),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Launch Patch"
                )
            } else {
                imageUrl?.let {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(92.dp),
                        model = it,
                        contentScale = ContentScale.Crop,
                        contentDescription = "Launch Patch"
                    )
                }
            }

            Column(
                modifier = Modifier
//                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                )
                Text(
                    text = setFormat(date),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
            Icon(
                modifier = Modifier.size(38.dp),
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = "favorite"
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun setFormat(date: String): String {
//    val inputString = "2006-03-25T10:30:00+12:00"
    val formatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm", Locale.ENGLISH)

    val dateTime = OffsetDateTime.parse(date)
    return dateTime.format(formatter)

//    println(formattedDate)
}
