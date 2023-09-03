package ir.adicom.jedbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.jedbizcard.data.UserRepositoryImpl
import ir.adicom.jedbizcard.domain.User
import ir.adicom.jedbizcard.ui.UserViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                        CustomTextField("دور کمر")
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
}

@Composable
fun CustomTextField(title: String) {
    var text by remember { mutableStateOf("0") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = title)
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(value = text, onValueChange = {text = it}, trailingIcon = {
            Row {
                Text(text = "cm")
                Spacer(modifier = Modifier.width(8.dp))
            }
        })
    }
}