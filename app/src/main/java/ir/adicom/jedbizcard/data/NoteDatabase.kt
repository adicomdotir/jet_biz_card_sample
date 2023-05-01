package ir.adicom.jedbizcard.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.adicom.jedbizcard.model.Note
import ir.adicom.jedbizcard.util.DateConverter
import ir.adicom.jedbizcard.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}