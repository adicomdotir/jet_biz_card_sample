package ir.adicom.jedbizcard.repository

import ir.adicom.jedbizcard.data.WeatherDao
import ir.adicom.jedbizcard.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao) {
    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()

    suspend fun getFavById(city: String): Favorite = weatherDao.getFavById(city)

    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)

    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavorite(favorite)

    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorite(favorite)

    suspend fun deleteAllFavorite() = weatherDao.deleteAllFavorite()
}