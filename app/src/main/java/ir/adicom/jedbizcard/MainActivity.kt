package ir.adicom.jedbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val fakeData: ArrayList<ParentDataClass> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setFakeData()
            MyApp(fakeData)
        }
    }

    private fun setFakeData() {
        val images = listOf<ChildDataClass>(
            ChildDataClass(R.drawable.movie_01),
            ChildDataClass(R.drawable.movie_02),
            ChildDataClass(R.drawable.movie_03),
            ChildDataClass(R.drawable.movie_04),
            ChildDataClass(R.drawable.movie_05),
            ChildDataClass(R.drawable.movie_06),
            ChildDataClass(R.drawable.movie_07),
        )

        fakeData.add(ParentDataClass("Best", images))
        fakeData.add(ParentDataClass("Favorite", images.shuffled()))
        fakeData.add(ParentDataClass("Random", images.shuffled()))
        fakeData.add(ParentDataClass("Others", images.shuffled()))
        fakeData.add(ParentDataClass("x-rated", images.shuffled()))
        fakeData.add(ParentDataClass("Unknown", images.shuffled()))
    }
}

data class ParentDataClass(val title: String, val images: List<ChildDataClass>)

data class ChildDataClass(val image: Int)

@Preview
@Composable
fun DefaultPreview() {
}

@Composable
fun MyApp(fakeData: ArrayList<ParentDataClass>) {

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
        LazyColumn() {
            items(fakeData.size) {
                CartUi(fakeData, it)
            }
        }
    }
}

@Composable
fun CartUi(fakeData: ArrayList<ParentDataClass>, i: Int) {
    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Text(text = fakeData[i].title, fontSize = 24.sp)
            LazyRow() {
                items(fakeData[i].images.size) {
                    Image(
                        painter = painterResource(id = fakeData[i].images[it].image),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
