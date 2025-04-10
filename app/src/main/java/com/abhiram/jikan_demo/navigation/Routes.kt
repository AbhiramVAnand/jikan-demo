package com.abhiram.jikan_demo.navigation

sealed class Routes(
    val routes: String
) {
    object HomeScreen : Routes(routes = "home")
    object DetailsScreen : Routes(routes = "details")
}