package ir.adicom.jedbizcard.features.authentication.presentetion.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.adicom.jedbizcard.features.authentication.domain.models.User

@Preview
@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = hiltViewModel()
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
            Button(onClick = {
                val user = User(id = 0, username = "admin", password = "123")

            }) {
                Text(text = "Login")
            }
            TextButton(onClick = { }) {
                Text(text = "Register")
            }
        }
    }
}