package ir.adicom.jedbizcard.feature_note.presentation.add_edit_note

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(val repository: NoteRepository) : ViewModel() {

}