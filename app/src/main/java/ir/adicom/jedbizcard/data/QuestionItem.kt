package ir.adicom.jedbizcard.data


import com.google.gson.annotations.SerializedName

data class QuestionItem(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("choices")
    val choices: List<String>,
    @SerializedName("question")
    val question: String
)