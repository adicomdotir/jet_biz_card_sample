package ir.adicom.jedbizcard.feature_note.domain.use_case

import ir.adicom.jedbizcard.feature_note.domain.model.Note
import ir.adicom.jedbizcard.feature_note.domain.repository.NoteRepository

class DeleteNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        return repository.deleteNote(note)
    }
}