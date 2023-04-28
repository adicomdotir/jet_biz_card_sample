package ir.adicom.jedbizcard.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.adicom.jedbizcard.screens.home.MainContent

@Composable
fun DetailScreen(navController: NavController, movie: String?) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Text(text = "Detail")
                Box {

                }
            }
        }
    }) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = movie.toString(), style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(23.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Go Back")
                }
            }
        }
    }
}