package com.tinder.redditapp.navigation

sealed class Screens(val route: String){
    object HomeScreen: Screens("home_screen")
    object DetailScreen: Screens("detail_screen")
}