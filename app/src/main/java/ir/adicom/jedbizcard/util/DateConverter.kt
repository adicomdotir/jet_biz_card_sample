package ir.adicom.jedbizcard.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun timeStampForDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timeStamp: Long): Date {
        return Date(timeStamp)
    }
}