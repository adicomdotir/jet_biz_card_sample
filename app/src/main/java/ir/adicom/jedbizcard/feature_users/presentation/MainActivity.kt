package ir.adicom.jedbizcard.feature_users.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.jedbizcard.ui.theme.JedBizCardTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp()
        }
    }
}

@Composable
fun WeatherApp() {
    JedBizCardTheme {
        Navigation()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JedBizCardTheme {
        Surface {
        }
    }
}