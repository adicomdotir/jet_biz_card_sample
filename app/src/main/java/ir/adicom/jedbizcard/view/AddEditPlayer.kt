package ir.adicom.jedbizcard.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

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
            OutlinedTextField(value = "", onValueChange = {})
            OutlinedTextField(value = "", onValueChange = {})
            OutlinedTextField(value = "", onValueChange = {})
            OutlinedTextField(value = "", onValueChange = {})

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
                onValueChangeFinished = {
                    // this is called when the user completed selecting the value
                    Log.d(
                        "MainActivity",
                        "Start: ${sliderValues.value.start}, End: ${sliderValues.value.endInclusive}"
                    )
                }
            )

            Text(text = "Start: ${sliderValues.value.start.toInt()}, End: ${sliderValues.value.endInclusive.toInt()}")
        }
    }
}
