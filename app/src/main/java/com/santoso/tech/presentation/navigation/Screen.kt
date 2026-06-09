package com.santoso.tech.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail/{coinId}") {
        fun createRoute(coinId: Int) = "detail/$coinId"
    }
}
