package com.abhiram.jikan_demo.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abhiram.jikan_demo.presentation.AnimeViewModel
import com.abhiram.jikan_demo.presentation.details.DetailsScreen
import com.abhiram.jikan_demo.presentation.home.HomeScreen

@Composable
fun AppNavHost(modifier: Modifier, navController: NavHostController = rememberNavController()) {
    val viewmodel : AnimeViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable(Routes.HomeScreen.routes) {
            HomeScreen(
                modifier = modifier,
                list = viewmodel.animesList,
                onItemClick = { animeId ->
                    Log.e("Id", animeId.toString())
                    navController.navigate(Routes.DetailsScreen.routes+"/$animeId")
                }
            )
        }
        composable(
            Routes.DetailsScreen.routes+"/{id}",
            arguments = listOf(navArgument("id"){ type = NavType.IntType})
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getInt("id") ?: 0
            DetailsScreen(modifier, title, viewmodel, navController)
        }
    }
}