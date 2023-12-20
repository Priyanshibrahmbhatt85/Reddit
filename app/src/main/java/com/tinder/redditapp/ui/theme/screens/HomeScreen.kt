package com.tinder.redditapp.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tinder.redditapp.data.model.ChildData
import com.tinder.redditapp.navigation.Screens
import com.tinder.redditapp.ui.theme.viewmodel.HomeViewModel
import com.tinder.redditapp.ui.theme.viewmodel.UIState

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val combinedFlow by viewModel.combinedFlow.collectAsState()

    when (combinedFlow) {
        is UIState.Loading -> {
            // Handle loading state, e.g., display a loading spinner
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }

        is UIState.Error -> {
            // Handle the error case, e.g., display an error message
            Text(text = "Error: ${(combinedFlow as UIState.Error).errorMessage}", modifier = Modifier.padding(16.dp))
        }

        is UIState.Success -> {
            // Display the list of posts
            LazyColumn {
                val size = (combinedFlow as UIState.Success).posts.size
                items(size) { post ->
                    val postData = (combinedFlow as UIState.Success).posts[post].data ?: ChildData()
                    if (!postData.thumbnail.isNullOrEmpty()) {
                        Item(posts = postData, onItemClick =
                        {
                            navController.navigate(Screens.DetailScreen.route + "/${postData.title}")
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Item(
    posts: ChildData,
    onItemClick: (String) -> Unit
) {
    val title = posts.title ?: ""
    Row(
        modifier = Modifier
            .clickable { onItemClick(title) }
            .padding(vertical = 16.dp, horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        CoilImage(imageUrl = posts.thumbnail ?: "")

        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = posts.title ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}


