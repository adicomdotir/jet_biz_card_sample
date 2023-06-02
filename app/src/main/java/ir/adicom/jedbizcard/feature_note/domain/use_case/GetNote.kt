package ir.adicom.jedbizcard.feature_note.domain.use_case

import ir.adicom.jedbizcard.feature_note.domain.model.Note
import ir.adicom.jedbizcard.feature_note.domain.repository.NoteRepository

class GetNote(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}