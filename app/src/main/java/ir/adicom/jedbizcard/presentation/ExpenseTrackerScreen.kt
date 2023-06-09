package ir.adicom.jedbizcard.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import ir.adicom.jedbizcard.domain.model.Expense
import ir.adicom.jedbizcard.domain.model.ExpenseType
import ir.adicom.jedbizcard.domain.use_cases.AddExpenseUseCase
import ir.adicom.jedbizcard.domain.use_cases.GetExpensesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpenseTrackerScreen(
    getExpensesUseCase: GetExpensesUseCase,
    addExpenseUseCase: AddExpenseUseCase
) {
    var expenses: List<Expense> = emptyList()
    LaunchedEffect(key1 = "key1", block = {
        expenses = getExpensesUseCase()
    })

    Column {
        expenses.forEach { expense ->
            Text(text = expense.toString())
        }
    }

    FloatingActionButton(onClick = {

    }) {
        Text(text = "Add Expense")
    }

}