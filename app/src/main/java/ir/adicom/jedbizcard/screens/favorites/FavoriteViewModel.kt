package ir.adicom.jedbizcard.screens.favorites

import android.util.Log
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.model.Favorite
import ir.adicom.jedbizcard.repository.WeatherDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val weatherDbRepository: WeatherDbRepository) :
    ViewModel() {
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList: StateFlow<List<Favorite>> = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            weatherDbRepository.getFavorites().distinctUntilChanged().collect {
                if (it.isEmpty()) {
                    Log.e("TAG", ": Empty List")
                } else {
                    _favList.value = it
                }
            }
        }
    }

    fun insertFavorite(favorite: Favorite) =
        viewModelScope.launch { weatherDbRepository.insertFavorite(favorite = favorite) }

    fun updateFavorite(favorite: Favorite) =
        viewModelScope.launch { weatherDbRepository.updateFavorite(favorite = favorite) }

    fun deleteFavorite(favorite: Favorite) =
        viewModelScope.launch { weatherDbRepository.deleteFavorite(favorite = favorite) }
}