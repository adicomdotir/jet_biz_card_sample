package ir.adicom.jedbizcard.widget

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ir.adicom.jedbizcard.R
import ir.adicom.jedbizcard.model.Weather
import ir.adicom.jedbizcard.model.WeatherItem
import ir.adicom.jedbizcard.utils.formatDate
import ir.adicom.jedbizcard.utils.formatDateTime
import ir.adicom.jedbizcard.utils.formatDecimals


@Composable
fun WeatherDetailRow(weatherItem: WeatherItem) {
    val imageUrl = "https://openweathermap.org/img/wn/${weatherItem.weather[0].icon}.png"
    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = formatDate(weatherItem.dt).split(",")[0], modifier = Modifier.padding(start = 5.dp))
            WeatherStateImage(imageUrl = imageUrl)
            Surface(
                modifier = Modifier.padding(0.dp),
                shape = CircleShape,
                color = Color(0xFFFFC400)
            ) {
                Text(
                    text = weatherItem.weather[0].description,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.caption
                )
            }
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.SemiBold)) {
                    append(formatDecimals(weatherItem.temp.max) + "°")
                }
                withStyle(style = SpanStyle(color = Color.LightGray, fontWeight = FontWeight.SemiBold)) {
                    append(formatDecimals(weatherItem.temp.min) + "°")
                }
            })
        }
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
            Text(
                text = formatDateTime(weatherItem.sunrise),
                style = MaterialTheme.typography.caption
            )
        }
        Row {
            Text(
                text = formatDateTime(weatherItem.sunset),
                style = MaterialTheme.typography.caption
            )
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
