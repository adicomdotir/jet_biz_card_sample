package ir.adicom.jedbizcard.feature_note.domain.use_case

import ir.adicom.jedbizcard.feature_note.domain.model.InvalidNoteException
import ir.adicom.jedbizcard.feature_note.domain.model.Note
import ir.adicom.jedbizcard.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) throw InvalidNoteException("enter title")
        if (note.content.isBlank()) throw InvalidNoteException("enter content")
        return repository.insertNote(note)
    }
}