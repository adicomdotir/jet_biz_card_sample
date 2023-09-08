package ir.adicom.jedbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val fakeData: ArrayList<String> = arrayListOf(
        "Java",
        "JavaScript",
        "C#",
        "C++",
        "Dart",
        "Kotlin",
        "Swift",
        "Go",
        "PHP",
        "Rust",
        "Ruby",
        "TypeScript",
        "Objective-C",
        "Ruby",
        "Perl",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(fakeData)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
}

@Composable
fun MyApp(fakeData: ArrayList<String>) {

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
        Column(modifier = Modifier.fillMaxSize()) {
            val state = remember {
                mutableStateOf(TextFieldValue())
            }
            TextFieldUi(state)
            LazyColumn() {
                items(
                    fakeData.filter { it.contains(state.value.text, ignoreCase = true) },
                    key = { it }) { item ->
                    CartUi(item)
                }
            }
        }
    }
}

@Composable
fun TextFieldUi(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value, onValueChange = {
            state.value = it
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(24.dp))
            .border(2.dp, Color.DarkGray, RoundedCornerShape(24.dp)),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
        )
    )
}

@Composable
fun CartUi(item: String) {
    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = item, fontSize = 24.sp)
        }
    }
}
