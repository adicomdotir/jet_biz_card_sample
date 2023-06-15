package ir.adicom.jedbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.jedbizcard.features.authentication.presentetion.login.LoginScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SampleCard()
}

@Composable
fun SampleCard() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(0.5.dp, Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(20.dp))
    ) {
        Image(painter = painterResource(id = R.drawable.wind), contentDescription = "")
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Title", fontSize = 24.sp)
            Text(text = "Subtitle", fontSize = 24.sp)
        }
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Outlined.FavoriteBorder,
                contentDescription = "icon"
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Read Now")
            }
        }
    }
}