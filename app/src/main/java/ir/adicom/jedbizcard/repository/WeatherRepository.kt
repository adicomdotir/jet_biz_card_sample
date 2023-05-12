package ir.adicom.jedbizcard.repository

import android.util.Log
import ir.adicom.jedbizcard.data.DataOrException
import ir.adicom.jedbizcard.model.Weather
import ir.adicom.jedbizcard.model.WeatherObject
import ir.adicom.jedbizcard.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {

        val response = try {

            api.getWeather(query = cityQuery)
        } catch (e: Exception) {

            Log.e("TAG", "Repo $e")
            return DataOrException(e = e)
        }
        Log.e("TAG", "Repo $response")
        return DataOrException(data = response)
    }
}
