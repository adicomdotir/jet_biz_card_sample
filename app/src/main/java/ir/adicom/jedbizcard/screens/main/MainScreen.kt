package ir.adicom.jedbizcard.screens.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
import ir.adicom.jedbizcard.widget.WeatherAppBar

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
            color = Color.Yellow
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
    }
}

@Composable
fun SunsetSunriseRow(weatherItem: WeatherItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "sunrise",
                modifier = Modifier.size(30.dp)
            )
            Text(text = formatDateTime(weatherItem.sunrise), style = MaterialTheme.typography.caption)
        }
        Row {
            Text(text = formatDateTime(weatherItem.sunset), style = MaterialTheme.typography.caption)
            Icon(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "sunset",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun HumidityWindPressureRow(data: Weather) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "image humidity",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${data.list[0].humidity} %")
        }
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = "image pressure",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${data.list[0].pressure} psi")
        }
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "image wind",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${data.list[0].speed} mph")
        }
    }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(data = imageUrl, builder = {
            this.listener(
                onError = { request, ex ->
                    Log.e("TAG", "MainContent: ${ex.throwable.message}")
                }
            )
        }),
        contentDescription = "icon image",
        modifier = Modifier.size(80.dp)
    )
}
