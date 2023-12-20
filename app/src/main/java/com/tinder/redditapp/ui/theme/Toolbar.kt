package com.tinder.redditapp.ui.theme

import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Toolbar(title: String, navController: NavController, isVisible: Boolean) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                if(isVisible){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                }
            }
        },
        backgroundColor = Orange,
        contentColor = Color.White
    )
}