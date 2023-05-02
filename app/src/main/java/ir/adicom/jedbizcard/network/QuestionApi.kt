package ir.adicom.jedbizcard.network

import ir.adicom.jedbizcard.data.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}