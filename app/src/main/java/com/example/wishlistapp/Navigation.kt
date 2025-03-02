package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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
        composable(Screen.AddScreen.routeName + "/{id}",
            //ToDO pass below arguments to my route composable when I created it
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ) { entry ->
            //TODO here we unpack it (we are looking for a particular argument like id)
            val id = if (entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddEditDetail(id = id, viewModel = viewModel, navController = navController)
        }
    }
}