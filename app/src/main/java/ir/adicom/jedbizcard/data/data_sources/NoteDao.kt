package ir.adicom.jedbizcard.data.data_sources

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import ir.adicom.jedbizcard.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = REPLACE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM Notes ORDER BY id ASC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Notes WHERE id = :id")
    suspend fun getNote(id: Int): Note

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)
}