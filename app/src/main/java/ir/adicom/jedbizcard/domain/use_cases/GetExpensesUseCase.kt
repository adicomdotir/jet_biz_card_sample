package ir.adicom.jedbizcard.domain.use_cases

import ir.adicom.jedbizcard.domain.model.Expense
import ir.adicom.jedbizcard.domain.repository.ExpenseRepository

class GetExpensesUseCase(private val expenseRepository: ExpenseRepository) {
    suspend operator fun invoke(): List<Expense> = expenseRepository.getExpenses()
}