package ir.adicom.jedbizcard.data.repository

import ir.adicom.jedbizcard.data.data_sources.NoteDao
import ir.adicom.jedbizcard.domain.model.Note
import ir.adicom.jedbizcard.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    override suspend fun getNoteById(id: Int): Note = noteDao.getNote(id)

    override suspend fun addNote(note: Note) = noteDao.addNote(note)
}