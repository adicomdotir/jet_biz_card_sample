package ir.adicom.jedbizcard.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.adicom.jedbizcard.model.Unit
import ir.adicom.jedbizcard.widget.WeatherAppBar

@Composable
fun SettingsScreen(
    navController: NavController,
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val unitToggleButton = remember {
        mutableStateOf(false)
    }
    val measurementUnits = listOf<String>("Imperial (F)", "Metric (C)")
    val choiceFromDb = settingsViewModel.unitList.collectAsState().value
    val defaultChoice = if (choiceFromDb.isEmpty()) measurementUnits[0] else choiceFromDb[0].unit
    val choiceState = remember {
        mutableStateOf(defaultChoice)
    }

    Scaffold(topBar = {
        WeatherAppBar(
            navController = navController,
            title = "Settings",
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
            onButtonClicked = {
                navController.popBackStack()
            }
        )
    }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Change Units", modifier = Modifier.padding(bottom = 15.dp))
                IconToggleButton(
                    checked = !unitToggleButton.value,
                    onCheckedChange = {
                        unitToggleButton.value = !it
                        if (unitToggleButton.value) {
                            choiceState.value = "Imperial (F)"
                        } else {
                            choiceState.value = "Metric (C)"
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clip(shape = RectangleShape)
                        .background(
                            Color.Magenta
                        )
                ) {
                    Text(text = if (unitToggleButton.value) "Fahrenheit F" else "Celsius C")
                }

                Button(
                    onClick = {
                        settingsViewModel.deleteAllUnit()
                        settingsViewModel.insertUnit(unit = Unit(unit = choiceState.value))
                    },
                    modifier = Modifier
                        .padding(3.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(34.dp)
                ) {
                    Text(text = "Save", modifier = Modifier.padding(4.dp), fontSize = 17.sp)
                }
            }
        }
    }
}