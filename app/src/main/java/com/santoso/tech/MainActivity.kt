package com.santoso.tech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.santoso.tech.presentation.detail.DetailScreen
import com.santoso.tech.presentation.home.HomeScreen
import com.santoso.tech.presentation.navigation.Screen
import com.santoso.tech.ui.theme.CryptoIndoinfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoIndoinfoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(route = Screen.Home.route) {
                            HomeScreen(
                                onNavigateToDetail = { coinId ->
                                    navController.navigate(Screen.Detail.createRoute(coinId))
                                }
                            )
                        }
                        composable(
                            route = Screen.Detail.route,
                            arguments = listOf(
                                navArgument("coinId") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            DetailScreen(
                                onNavigateBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
