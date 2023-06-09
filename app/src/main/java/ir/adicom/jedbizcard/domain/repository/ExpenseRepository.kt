package ir.adicom.jedbizcard.domain.repository

import ir.adicom.jedbizcard.domain.model.Expense

interface ExpenseRepository {
    suspend fun getExpenses(): List<Expense>
    suspend fun addExpense(expense: Expense)
}