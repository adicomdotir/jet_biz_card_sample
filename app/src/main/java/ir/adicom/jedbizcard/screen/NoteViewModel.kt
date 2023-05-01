package ir.adicom.jedbizcard.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.model.Note
import ir.adicom.jedbizcard.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
//    private val noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect {
                if (it.isEmpty()) {
                    Log.e("TAG", "Empty: note list")
                } else {
                    _noteList.value = it
                }
            }
        }
//        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

}