package ir.adicom.jedbizcard.screens.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.network.HttpException
import ir.adicom.jedbizcard.R
import ir.adicom.jedbizcard.data.DataOrException
import ir.adicom.jedbizcard.model.Weather
import ir.adicom.jedbizcard.model.WeatherItem
import ir.adicom.jedbizcard.utils.formatDate
import ir.adicom.jedbizcard.utils.formatDateTime
import ir.adicom.jedbizcard.utils.formatDecimals
import ir.adicom.jedbizcard.widget.*

@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel = hiltViewModel()) {
    val weatherData =
        produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue = DataOrException(
                loading = true
            )
        ) {
            value = mainViewModel.getWeatherData("Ardabil")
        }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        MainScaffold(data = weatherData.data!!, navController = navController)

    }
}

@Composable
fun MainScaffold(data: Weather, navController: NavHostController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = data.city.name + " ,${data.city.country}",
            navController = navController,
            elevation = 5.dp
        )
    }) {
        MainContent(data)
    }
}

@Composable
fun MainContent(data: Weather) {
    val imageUrl = "https://openweathermap.org/img/wn/${data.list[0].weather[0].icon}.png"
    Log.e("TAG", "MainContent: $imageUrl")
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            formatDate(data.list[0].dt),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(6.dp)
        )
        Surface(
            modifier = Modifier
                .padding(4.dp)
                .size(200.dp),
            shape = CircleShape,
            color = Color(0xFFFFC400)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherStateImage(imageUrl = imageUrl)
                Text(
                    text = formatDecimals(data.list[0].temp.day),
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.h4
                )
                Text(text = data.list[0].weather[0].main, fontStyle = FontStyle.Italic)
            }
        }
        HumidityWindPressureRow(data)
        Divider()
        SunsetSunriseRow(data.list[0])
        Text(
            text = "Text",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFFEEF1EF),
            shape = RoundedCornerShape(
                CornerSize(14.dp)
            )
        ) {
            LazyColumn(modifier = Modifier.padding(2.dp), contentPadding = PaddingValues(1.dp)) {
                items(data.list) { weatherItem ->
                    WeatherDetailRow(weatherItem)
                }
            }
        }
    }
}
