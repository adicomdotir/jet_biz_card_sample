package ir.adicom.jedbizcard.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.adicom.jedbizcard.data.FakeDogDatabase
import ir.adicom.jedbizcard.navigation.Screen

@Composable
fun WigglesMain(toggleTheme: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            Home(navController = navController, dogList = FakeDogDatabase.dogList, toggleTheme)
        }
        composable(
            "${Screen.Details.route}/{id}/{title}/{location}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
//            Details(navController, it.arguments?.getInt("id") ?: 0)
        }
    }
}