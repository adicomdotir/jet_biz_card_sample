package ir.adicom.jedbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
            Surface(color = MaterialTheme.colors.background) {
                val ur = UserRepositoryImpl()
                var user: User? = null
                val userViewModel = UserViewModel(ur).user.observe(this) {
                    user = it
                }
                Log.e("TAG", "onCreate: ${user?.name}", )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = user?.name ?: "", modifier = Modifier.padding(16.dp))
                    Button(onClick = {
                    }) {
                        Text(text = "Get User")
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