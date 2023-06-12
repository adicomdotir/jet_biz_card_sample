package ir.adicom.jedbizcard.features.authentication.presentetion.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    text = "Login Screen",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Username")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Password")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { }) {
                Text(text = "Login")
            }
            TextButton(onClick = { }) {
                Text(text = "Register")
            }
        }
    }
}