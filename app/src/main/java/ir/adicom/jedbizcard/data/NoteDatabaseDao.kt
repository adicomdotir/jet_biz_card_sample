package ir.adicom.jedbizcard.data

import androidx.room.*
import ir.adicom.jedbizcard.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * FROM note_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note_tbl WHERE id=:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("DELETE FROM note_tbl")
    suspend fun deleteAll()
}