package ir.adicom.jedbizcard.feature_note.presentation.notes

import ir.adicom.jedbizcard.feature_note.domain.model.Note
import ir.adicom.jedbizcard.feature_note.domain.util.NoteOrder
import ir.adicom.jedbizcard.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
