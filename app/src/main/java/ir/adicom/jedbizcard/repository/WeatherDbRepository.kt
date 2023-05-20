package ir.adicom.jedbizcard.repository

import ir.adicom.jedbizcard.data.WeatherDao
import ir.adicom.jedbizcard.model.Favorite
import ir.adicom.jedbizcard.model.Unit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao) {
    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()

    suspend fun getFavById(city: String): Favorite = weatherDao.getFavById(city)

    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)

    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavorite(favorite)

    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorite(favorite)

    suspend fun deleteAllFavorite() = weatherDao.deleteAllFavorite()

    fun getUnits(): Flow<List<Unit>> = weatherDao.getUnits()

    suspend fun insertUnit(unit: Unit) = weatherDao.insertUnit(unit)

    suspend fun updateUnit(unit: Unit) = weatherDao.updateUnit(unit)

    suspend fun deleteUnit(unit: Unit) = weatherDao.deleteUnit(unit)

    suspend fun deleteAllUnit() = weatherDao.deleteAllUnit()
}