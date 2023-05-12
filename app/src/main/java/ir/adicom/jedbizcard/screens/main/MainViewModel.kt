package ir.adicom.jedbizcard.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.data.DataOrException
import ir.adicom.jedbizcard.model.Weather
import ir.adicom.jedbizcard.model.WeatherObject
import ir.adicom.jedbizcard.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    suspend fun getWeatherData(city: String): DataOrException<Weather, Boolean, Exception> {
        Log.e("TAG", "ViewModel")

        return repository.getWeather(city)
    }
}