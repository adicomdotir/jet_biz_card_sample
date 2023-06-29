package ir.adicom.jedbizcard.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.adicom.jedbizcard.component.ItemDogCard
import ir.adicom.jedbizcard.component.TopBar
import ir.adicom.jedbizcard.model.Dog
import ir.adicom.jedbizcard.model.Player
import ir.adicom.jedbizcard.navigation.Screen

@Composable
fun Home(navController: NavHostController, playerList: List<Player>, toggleTheme: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text("Home (Season = 2022/2023)")
            },
            actions = {
                OverflowMenu {
                    DropdownMenuItem(onClick = {
                        navController.navigate(Screen.AddEditPlayer.route)
                    }) {
                        Text("Add Player")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Update Season")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Filter")
                    }
                }
            }
        )
    }) {
        LazyColumn {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextItem(modifier = Modifier.weight(1f), title = "Pos", isHeader = true)
                    TextItem(modifier = Modifier.weight(2f), title = "FirstName", isHeader = true)
                    TextItem(modifier = Modifier.weight(2f), title = "LastName", isHeader = true)
                    TextItem(modifier = Modifier.weight(1f), title = "Age", isHeader = true)
                    TextItem(modifier = Modifier.weight(1f), title = "Min", isHeader = true)
                    TextItem(modifier = Modifier.weight(1f), title = "Max", isHeader = true)
                    TextItem(modifier = Modifier.weight(1.5f), title = "Overall", isHeader = true)

                }
            }
            items(playerList) { item ->
                ItemRow(item, navController)
            }
        }
    }

}

@Composable
fun OverflowMenu(content: @Composable () -> Unit) {
    var showMenu by remember { mutableStateOf(false) }

    IconButton(onClick = {
        showMenu = !showMenu
    }) {
        Icon(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = "more_icon",
        )
    }
    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false }
    ) {
        content()
    }
}

@Composable
fun ItemRow(item: Player, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                navController.navigate("details/${item.id}")

            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextItem(modifier = Modifier.weight(1f), title = item.position.name)
        TextItem(modifier = Modifier.weight(2f), title = item.firstName)
        TextItem(modifier = Modifier.weight(2f), title = item.lastName)
        TextItem(modifier = Modifier.weight(1f), title = item.age.toString())
        TextItem(modifier = Modifier.weight(1f), title = item.min_potential.toString())
        TextItem(modifier = Modifier.weight(1f), title = item.max_potential.toString())
        TextItem(modifier = Modifier.weight(1.5f), title = item.overall.toString())

    }
}

@Composable
fun TextItem(
    modifier: Modifier,
    title: String,
    color: Color = Color.White,
    isHeader: Boolean = false
) {
    Box(
        modifier = modifier
            .background(color)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal
        )
    }
}