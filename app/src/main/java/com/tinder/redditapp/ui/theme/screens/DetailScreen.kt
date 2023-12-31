package com.tinder.redditapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    title: String
) {

        Spacer(modifier = Modifier.width(16.dp))
        Column(  modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
           horizontalAlignment = Alignment.CenterHorizontally
           ) {

            Text(
                text = title,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis
            )

    }
}