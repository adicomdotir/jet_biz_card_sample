package ir.adicom.jedbizcard.domain.use_cases

import ir.adicom.jedbizcard.domain.model.Expense
import ir.adicom.jedbizcard.domain.repository.ExpenseRepository

class AddExpenseUseCase(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke(expense: Expense) = expenseRepository.addExpense(expense)
}