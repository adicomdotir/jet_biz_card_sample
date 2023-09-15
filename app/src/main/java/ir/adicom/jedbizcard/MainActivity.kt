package ir.adicom.jedbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
private fun MyApp(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableStateOf(0)
    }

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFD5356), Color(0xFFFF6EAA)),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )

    Surface(modifier.fillMaxSize()) {
        Column {
            Box(
                modifier = Modifier.padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = 13.dp,
                    bottom = 23.dp
                )
            ) {
                Text("Home", fontSize = 32.sp, fontWeight = FontWeight.W700)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(gradientBrush)

            ) {
                Column {
                    Text(
                        "Your total asset portfolio",
                        modifier = Modifier.padding(start = 30.dp, top = 30.dp),
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        "\$ 2.240.559",
                        modifier = Modifier.padding(start = 30.dp, top = 8.dp, bottom = 30.dp),
                        fontWeight = FontWeight.W600,
                        fontSize = 32.sp,
                        color = Color.White
                    )
                }
            }
            Box(
                modifier = Modifier.padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = 20.dp,
                    bottom = 20.dp
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "What’s to Buy?",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W700
                    )
                    Text(
                        "See All",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFFFE555D)
                    )
                }
            }
            Row {
                CompanyItem(
                    startColor = Color.Black,
                    endColor = Color(0xFF676767),
                    title = "AAPL",
                    price = "\$ 364.11"
                )
                CompanyItem(
                    startColor = Color(0xFFE80B0B),
                    endColor = Color(0xFFDC4F00),
                    title = "MCD",
                    price = "\$ 183.52"
                )
                CompanyItem(
                    startColor = Color.Black,
                    endColor = Color(0xFF676767),
                    title = "AAPL",
                    price = "\$ 364.11"
                )
                CompanyItem(
                    startColor = Color.Black,
                    endColor = Color(0xFF676767),
                    title = "AAPL",
                    price = "\$ 364.11"
                )
            }
        }
    }
}

@Composable
fun CompanyItem(startColor: Color, endColor: Color, title: String, price: String) {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(startColor, endColor),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )

    Box(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(gradientBrush)

    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                title,
                modifier = Modifier.padding(start = 0.dp, top = 0.dp),
                fontWeight = FontWeight.W500,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                price,
                modifier = Modifier.padding(start = 0.dp, top = 0.dp, bottom = 0.dp),
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}