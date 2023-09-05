package ir.adicom.jedbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp()
}

@Composable
fun MyApp() {
    val cells = remember {
        mutableStateListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    }
    val player = remember {
        mutableStateOf(1)
    }
    val gameEnd = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "MyApp")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    cells[0] = 0
                    cells[1] = 0
                    cells[2] = 0
                    cells[3] = 0
                    cells[4] = 0
                    cells[5] = 0
                    cells[6] = 0
                    cells[7] = 0
                    cells[8] = 0
                    gameEnd.value = false
                    player.value = 1

                },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (gameEnd.value) Text(
                text = "Winner is Player ${player.value}",
                fontSize = 32.sp
            ) else Text(
                text = "Player ${player.value}",
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            BoxRow(cells, 0, player, gameEnd)
            BoxRow(cells, 1, player, gameEnd)
            BoxRow(cells, 2, player, gameEnd)
        }
    }
}

@Composable
fun BoxRow(
    cells: SnapshotStateList<Int>,
    i: Int,
    player: MutableState<Int>,
    gameEnd: MutableState<Boolean>
) {
    Row {
        Cell(cells, i, 0, player, gameEnd)
        Cell(cells, i, 1, player, gameEnd)
        Cell(cells, i, 2, player, gameEnd)
    }
}

@Composable
fun Cell(
    cells: SnapshotStateList<Int>,
    i: Int,
    j: Int,
    player: MutableState<Int>,
    gameEnd: MutableState<Boolean>
) {
    val idx = i * 3 + j
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(MaterialTheme.colors.primary)
            .clickable {
                if (cells[idx] == 0 && !gameEnd.value) {
                    cells[idx] = player.value
                    if (!checkWinner(cells)) {
                        if (player.value == 1) {
                            player.value = 2
                        } else {
                            player.value = 1
                        }
                    } else {
                        gameEnd.value = true
                    }
                }

            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = getSymbol(cells[idx]), fontSize = 48.sp, color = Color.White)
    }
}

fun getSymbol(item: Int): String {
    return if (item == 1) "X" else if (item == 2) "O" else ""
}

fun checkWinner(cells: SnapshotStateList<Int>): Boolean {
    if (cells[0] != 0 && cells[0] == cells[1] && cells[1] == cells[2]) return true
    if (cells[3] != 0 && cells[3] == cells[4] && cells[4] == cells[5]) return true
    if (cells[6] != 0 && cells[6] == cells[7] && cells[7] == cells[8]) return true

    if (cells[0] != 0 && cells[0] == cells[3] && cells[3] == cells[6]) return true
    if (cells[1] != 0 && cells[1] == cells[4] && cells[4] == cells[7]) return true
    if (cells[2] != 0 && cells[2] == cells[5] && cells[5] == cells[8]) return true

    if (cells[0] != 0 && cells[0] == cells[4] && cells[4] == cells[8]) return true
    if (cells[2] != 0 && cells[2] == cells[4] && cells[4] == cells[6]) return true

    return false
}