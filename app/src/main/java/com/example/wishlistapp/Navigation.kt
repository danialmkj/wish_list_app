package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController, startDestination = Screen.HomeScreen.routeName
    ) {
        composable(Screen.HomeScreen.routeName) {
            HomeView(navController, viewModel)
        }
        composable(Screen.AddScreen.routeName) {
            AddEditDetail(id = 0L, viewModel = viewModel, navController = navController)
        }
    }
}