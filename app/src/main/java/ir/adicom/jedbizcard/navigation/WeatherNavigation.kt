package ir.adicom.jedbizcard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.adicom.jedbizcard.screens.main.MainScreen
import ir.adicom.jedbizcard.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SearchScreen.name) {
        composable(WeatherScreens.SearchScreen.name) {
            WeatherSplashScreen(navController = navController)
        }
        composable(WeatherScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }
    }
}