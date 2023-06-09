package ir.adicom.jedbizcard.domain.model

import java.time.LocalDate

data class Expense(val amount: Double, val type: ExpenseType, val date: LocalDate)

enum class ExpenseType {
    FOOD,
    SHOPPING,
    TRAVEL
}