package ir.adicom.jedbizcard.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.adicom.jedbizcard.data.FakePlayerDatabase

@Composable
fun Details(navController: NavController, id: Int) {
    val player = FakePlayerDatabase.playerList.find {
        it.id == id
    }
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text("Player")
                },
                backgroundColor = MaterialTheme.colors.primarySurface,
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }, actions = {
                    IconButton(
                        onClick = {
                            if (FakePlayerDatabase.removePlayer(player!!)) {
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Icon(Icons.Filled.Delete, null, tint = Color.White)

                    }
                })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Position: ${player?.position}")
            Text(text = "FirstName: ${player?.firstName}")
            Text(text = "LastName: ${player?.lastName}")
            Text(text = "Age: ${player?.age}")
            Text(text = "Overall: ${player?.overall}")
            Text(text = "Min Potential: ${player?.min_potential}")
            Text(text = "Max Potential: ${player?.max_potential}")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text("History")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Edit")
                }
            }
        }
    }

}