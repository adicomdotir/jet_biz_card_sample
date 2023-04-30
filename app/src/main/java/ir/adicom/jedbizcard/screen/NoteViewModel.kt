package ir.adicom.jedbizcard.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import ir.adicom.jedbizcard.data.NoteDataSource
import ir.adicom.jedbizcard.model.Note

class NoteViewModel: ViewModel() {
    private val noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }
}