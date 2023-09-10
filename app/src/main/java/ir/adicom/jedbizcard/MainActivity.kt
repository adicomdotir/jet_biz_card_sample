package ir.adicom.jedbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

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

                },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val redColorTextField = remember {
                mutableStateOf(TextFieldValue("0"))
            }
            val greenColorTextField = remember {
                mutableStateOf(TextFieldValue("0"))
            }
            val blueColorTextField = remember {
                mutableStateOf(TextFieldValue("0"))
            }
            OutlinedTextField(
                value = redColorTextField.value,
                onValueChange = {
                    redColorTextField.value = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = greenColorTextField.value,
                onValueChange = {
                    greenColorTextField.value = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = blueColorTextField.value,
                onValueChange = {
                    blueColorTextField.value = it
                },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = convertToHex(
                    redColorTextField.value.text,
                    greenColorTextField.value.text,
                    blueColorTextField.value.text
                ).uppercase(Locale.ROOT)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        Color(
                            redColorTextField.value.text.toInt(),
                            greenColorTextField.value.text.toInt(),
                            blueColorTextField.value.text.toInt()
                        )
                    )
            ) {

            }
        }
    }
}

fun convertToHex(red: String, green: String, blue: String): String {
    return "${red.toInt().toString(16)}${green.toInt().toString(16)}${blue.toInt().toString(16)}"
}