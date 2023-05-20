package ir.adicom.jedbizcard.screens.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.model.Favorite
import ir.adicom.jedbizcard.model.Unit
import ir.adicom.jedbizcard.repository.WeatherDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repository: WeatherDbRepository) :
    ViewModel() {
    private val _unitList = MutableStateFlow<List<Unit>>(emptyList())
    val unitList = _unitList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUnits()
                .distinctUntilChanged()
                .collect {
                    _unitList.value = it
                }
        }
    }

    fun insertUnit(unit: Unit) =
        viewModelScope.launch { repository.insertUnit(unit = unit) }

    fun updateUnit(unit: Unit) =
        viewModelScope.launch { repository.updateUnit(unit = unit) }

    fun deleteUnit(unit: Unit) =
        viewModelScope.launch { repository.deleteUnit(unit = unit) }

    fun deleteAllUnit() = viewModelScope.launch { repository.deleteAllUnit() }
}