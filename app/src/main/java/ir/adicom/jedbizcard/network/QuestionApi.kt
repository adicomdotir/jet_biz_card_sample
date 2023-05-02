package ir.adicom.jedbizcard.network

import ir.adicom.jedbizcard.model.Question
import ir.adicom.jedbizcard.model.QuestionItem
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}