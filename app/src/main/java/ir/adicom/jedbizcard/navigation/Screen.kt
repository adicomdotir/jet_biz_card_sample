package ir.adicom.jedbizcard.navigation

import androidx.annotation.StringRes
import ir.adicom.jedbizcard.R

sealed class Screen(val route: String, @StringRes resourceId: Int) {
    object Home: Screen("home", R.string.text_home)
    object Details: Screen("details", R.string.text_details)
    object AddEditPlayer: Screen("add_edit_player", R.string.text_add_edit_player)
}
