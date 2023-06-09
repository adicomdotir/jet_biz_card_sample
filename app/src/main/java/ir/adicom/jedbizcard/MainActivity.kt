package ir.adicom.jedbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.jedbizcard.data.repository.ExpenseRepositoryImpl
import ir.adicom.jedbizcard.domain.use_cases.AddExpenseUseCase
import ir.adicom.jedbizcard.domain.use_cases.GetExpensesUseCase
import ir.adicom.jedbizcard.presentation.ExpenseTrackerScreen

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerScreen(
                getExpensesUseCase = GetExpensesUseCase(ExpenseRepositoryImpl()),
                addExpenseUseCase = AddExpenseUseCase(ExpenseRepositoryImpl()),
            )
        }
    }
}


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview
@Composable
fun DefaultPreview() {
}