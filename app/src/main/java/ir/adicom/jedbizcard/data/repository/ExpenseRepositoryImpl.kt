package ir.adicom.jedbizcard.data.repository

import ir.adicom.jedbizcard.domain.model.Expense
import ir.adicom.jedbizcard.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl: ExpenseRepository {
    override suspend fun getExpenses(): List<Expense> {
        TODO("Not yet implemented")
    }

    override suspend fun addExpense(expense: Expense) {
        TODO("Not yet implemented")
    }
}