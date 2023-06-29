package ir.adicom.jedbizcard.component

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun TopBar(onToggle: () -> Unit) {
    TopAppBar {
        Text(text = "Home")
    }
}