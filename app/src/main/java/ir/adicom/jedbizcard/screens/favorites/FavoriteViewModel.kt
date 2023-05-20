package ir.adicom.jedbizcard.screens.favorites

import android.util.Log
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
class FavoriteViewModel @Inject constructor(private val repository: WeatherDbRepository) :
    ViewModel() {
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFavorites()
                .distinctUntilChanged()
                .collect {
                    _favList.value = it
                }
        }
    }

    fun insertFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.insertFavorite(favorite = favorite) }

    fun updateFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.updateFavorite(favorite = favorite) }

    fun deleteFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.deleteFavorite(favorite = favorite) }
}