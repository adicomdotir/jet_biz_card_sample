package ir.adicom.jedbizcard.domain.repository

import ir.adicom.jedbizcard.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun getNoteById(id: Int): Note

    suspend fun addNote(note: Note)
}