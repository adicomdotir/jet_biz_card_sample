package ir.adicom.jedbizcard.view

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.adicom.jedbizcard.data.FakePlayerDatabase
import ir.adicom.jedbizcard.model.Player
import ir.adicom.jedbizcard.model.PositionType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddEditPlayer(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text("Add Player")
                },
                backgroundColor = MaterialTheme.colors.primarySurface,
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val firstName = remember {
                mutableStateOf("")
            }
            val lastName = remember {
                mutableStateOf("")
            }
            val position = remember {
                mutableStateOf("")
            }
            val age = remember {
                mutableStateOf("16")
            }
            val overall = remember {
                mutableStateOf("50")
            }
            val saveBtnEnabled = remember {
                mutableStateOf(false)
            }

            fun shouldValidInput() {
                saveBtnEnabled.value = firstName.value.isNotEmpty() &&
                        lastName.value.isNotEmpty() &&
                        position.value.isNotEmpty() &&
                        age.value.isNotEmpty() &&
                        overall.value.isNotEmpty()
            }

            OutlinedTextField(
                value = firstName.value,
                onValueChange = {
                    firstName.value = it
                    shouldValidInput()
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "FirstName")
                })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = lastName.value,
                onValueChange = {
                    lastName.value = it
                    shouldValidInput()
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "LastName")
                })
            Spacer(modifier = Modifier.height(16.dp))

            DropdownPosition() {
                position.value = it
                shouldValidInput()
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = age.value.toString(),
                onValueChange = {
                    age.value = it
                    shouldValidInput()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Age")
                })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = overall.value.toString(),
                onValueChange = {
                    overall.value = it
                    shouldValidInput()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Overall")
                })

            val sliderValues = remember {
                mutableStateOf(70f..99f) // pass the initial values
            }

            RangeSlider(
                values = sliderValues.value,
                onValueChange = { sliderValues_ ->
                    sliderValues.value = sliderValues_
                },
                valueRange = 70f..99f,
                steps = 28,
            )

            Text(text = "Min Potential: ${sliderValues.value.start.toInt()}, Max Potential: ${sliderValues.value.endInclusive.toInt()}")
            Button(
                onClick = {
                    val playerList = FakePlayerDatabase.playerList
                    val player = Player(
                        playerList.size + 1,
                        firstName.value,
                        lastName.value,
                        age.value.toInt(),
                        sliderValues.value.start.toInt(),
                        sliderValues.value.endInclusive.toInt(),
                        overall.value.toInt(),
                        position = PositionType.valueOf(position.value)
                    )
                    playerList.add(player)
                    navController.popBackStack()
                },
                enabled = saveBtnEnabled.value
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
fun DropdownPosition(itemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val items = PositionType.values().map { it.name }
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .border(width = 1.dp, color = Color.Gray)
            .padding(8.dp)
    ) {
        Row(modifier = Modifier
            .clickable(onClick = { expanded = true })
        ) {
            val icon = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp
            Icon(imageVector = icon, contentDescription = "")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                items[selectedIndex], modifier = Modifier
                    .fillMaxWidth()
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                    itemSelected.invoke(items[selectedIndex])
                }) {
                    Text(text = s)
                }
            }
        }
    }
}