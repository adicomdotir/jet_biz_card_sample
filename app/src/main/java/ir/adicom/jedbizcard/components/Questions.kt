package ir.adicom.jedbizcard.components

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import ir.adicom.jedbizcard.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()

//    Log.e("TAG", "Questions: ${viewModel.data.value.data?.size}", )

    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
    } else {
        ///
    }
}