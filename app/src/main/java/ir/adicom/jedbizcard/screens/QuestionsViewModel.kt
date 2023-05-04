package ir.adicom.jedbizcard.screens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.data.DataOrException
import ir.adicom.jedbizcard.model.QuestionItem
import ir.adicom.jedbizcard.repository.QuestionRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {
     val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )

    init {
        Log.e("TAG", "init")
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true

            Log.e("TAG", "view model before")
            data.value = repository.getAllQuestions()
            Log.e("TAG", "view model getAllQuestions")
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }

    fun getQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}