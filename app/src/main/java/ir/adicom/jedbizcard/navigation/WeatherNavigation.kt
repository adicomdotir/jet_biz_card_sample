package ir.adicom.jedbizcard.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.adicom.jedbizcard.screens.main.MainScreen
import ir.adicom.jedbizcard.screens.main.MainViewModel
import ir.adicom.jedbizcard.screens.search.SearchScreen
import ir.adicom.jedbizcard.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SearchScreen.name) {
        composable(WeatherScreens.SearchScreen.name) {
            WeatherSplashScreen(navController = navController)
        }

        composable(WeatherScreens.MainScreen.name) {
            val mainViewModel: MainViewModel = hiltViewModel()
            MainScreen(navController = navController, mainViewModel)
        }

        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
    }
}