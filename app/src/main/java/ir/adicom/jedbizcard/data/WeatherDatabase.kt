package ir.adicom.jedbizcard.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.adicom.jedbizcard.model.Favorite
import ir.adicom.jedbizcard.model.Unit

@Database(entities = [Favorite::class, Unit::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}