package com.tinder.redditapp.ui.theme.screens

import androidx.compose.runtime.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tinder.redditapp.R

@Composable
fun CoilImage(imageUrl: String) {
    Image(
        painter = 
        rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = imageUrl)
                .apply(block = fun ImageRequest.Builder.() {
                    placeholder(R.drawable.ic_launcher_foreground)
                }).build()
        ),
        contentDescription = "Coil Image",
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(4.dp))
    )
}