package ir.adicom.jedbizcard.repository

import android.util.Log
import ir.adicom.jedbizcard.data.DataOrException
import ir.adicom.jedbizcard.model.Question
import ir.adicom.jedbizcard.model.QuestionItem
import ir.adicom.jedbizcard.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            Log.e("TAG", "api.getAllQuestions")
            dataOrException.data = api.getAllQuestions()
            Log.e("TAG", dataOrException.data?.size.toString())
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {

            Log.e("TAG", "catch error : ${exception.message}")
            dataOrException.e = exception
        }
        Log.e("TAG", "before return")
        return dataOrException
    }
}