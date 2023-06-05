package ir.adicom.jedbizcard.data.data_sources

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.adicom.jedbizcard.domain.model.ColorModelConverter
import ir.adicom.jedbizcard.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ColorModelConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
}