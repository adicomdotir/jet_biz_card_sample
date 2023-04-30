package ir.adicom.jedbizcard.data

import ir.adicom.jedbizcard.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Note 1", description = "Description 1"),
            Note(title = "Note 2", description = "Description 2"),
            Note(title = "Note 3", description = "Description 3"),
            Note(title = "Note 4", description = "Description 4"),
            Note(title = "Note 5", description = "Description 5"),
            Note(title = "Note 6", description = "Description 6"),
        )
    }
}