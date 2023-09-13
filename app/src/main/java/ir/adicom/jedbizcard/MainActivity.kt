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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
private fun MyApp(modifier: Modifier = Modifier) {
//    Row(
//        modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.DarkGray),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = "Pizza",
//            style = MaterialTheme.typography.h4,
//            modifier = Modifier.padding(start = 20.dp)
//        )
//        Text(
//            text = "$5",
//            style = MaterialTheme.typography.h6,
//            modifier = Modifier.padding(start = 20.dp)
//        )
//    }

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colors.surface),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Column Layout",
//            style = MaterialTheme.typography.h4,
//            color = MaterialTheme.colors.primary
//        )
//        Text(
//            text = "Pizza",
//            style = MaterialTheme.typography.h6,
//            color = MaterialTheme.colors.primary
//        )
//        Text(
//            text = "$5",
//            style = MaterialTheme.typography.h6,
//            color = MaterialTheme.colors.primary
//        )
//    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(Color.Green)
    ) {
        Text(text = "Top Start", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Top Center", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "Top End", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "Center Start", modifier = Modifier.align(Alignment.CenterStart))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "Center End", modifier = Modifier.align(Alignment.CenterEnd))
        Text(text = "Bottom Start", modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "Bottom Center", modifier = Modifier.align(Alignment.BottomCenter))
        Text(text = "Bottom End", modifier = Modifier.align(Alignment.BottomEnd))
    }
}
