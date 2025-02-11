package com.example.wishlistapp

//nobody can access to inherited this
sealed class Screen(val routeName: String) {
    object HomeScreen : Screen(routeName = "home_screen")
    object AddScreen : Screen(routeName = "add_screen") {

    }
}