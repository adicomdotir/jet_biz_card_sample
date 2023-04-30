package ir.adicom.jedbizcard

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.adicom.jedbizcard.data.NoteDataSource
import ir.adicom.jedbizcard.model.Note
import ir.adicom.jedbizcard.screen.NoteScreen
import ir.adicom.jedbizcard.screen.NoteViewModel
import ir.adicom.jedbizcard.ui.theme.JedBizCardTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JedBizCardTheme {
                Surface {
                    NotesApp()
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    val notesList = noteViewModel.getAllNotes()
    NoteScreen(
        notes = notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        }, onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JedBizCardTheme {
        Surface {
            NoteScreen(notes = listOf(), onAddNote = {}, onRemoveNote = {})
        }
    }
}