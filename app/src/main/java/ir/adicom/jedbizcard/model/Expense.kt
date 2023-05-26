package ir.adicom.jedbizcard.model

import java.time.LocalDateTime
import java.util.*

data class Expense(
    val id: Int,
    val title: String,
    val amount: Int,
    val category: String,
    val date: Long
)