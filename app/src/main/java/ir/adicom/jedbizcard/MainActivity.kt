package ir.adicom.jedbizcard

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.jedbizcard.model.Expense
import ir.adicom.jedbizcard.ui.theme.Purple500
import ir.adicom.jedbizcard.widgets.CustomAlertDialog
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTracker()
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun ExpenseTracker() {

    val keyboardController = LocalSoftwareKeyboardController.current

    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
    )
    val titleState = remember {
        mutableStateOf("")
    }
    val priceState = remember {
        mutableStateOf("")
    }
    val categoryState = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var selectedDate by remember { mutableStateOf(0L) }
    val selectedDateText = remember() {
        mutableStateOf("")
    }

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            val calendar = Calendar.getInstance()
            calendar.set(selectedYear, selectedMonth, selectedDayOfMonth)
            selectedDate = calendar.timeInMillis
            val sdf = SimpleDateFormat("yyyy/MM/dd")
            selectedDateText.value = sdf.format(Timestamp(calendar.timeInMillis))
        }, year, month, dayOfMonth
    )

    val expenses = remember {
        mutableStateListOf<Expense>()
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetContent = {
            val height = LocalConfiguration.current.screenHeightDp
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .height((height * 0.5).dp)
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = titleState.value,
                    onValueChange = {
                        titleState.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    label = { Text(text = "Title") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = priceState.value.toString(),
                    onValueChange = {
                        if (it.isNotEmpty()) {
                            priceState.value = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Price") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = categoryState.value,
                    onValueChange = {
                        categoryState.value = it
                    },

                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Category") })
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (selectedDate == 0L) {
                            "Please pick a date"
                        } else {
                            selectedDateText.value
                        }
                    )
                    Button(
                        onClick = {
                            datePicker.show()
                        }
                    ) {
                        Text(text = "Select a date")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        onClick = {
                            if (
                                selectedDate != 0L &&
                                titleState.value.isNotEmpty() &&
                                priceState.value.isNotEmpty() &&
                                categoryState.value.isNotEmpty()
                            ) {
                                expenses.add(
                                    Expense(
                                        expenses.size + 1,
                                        titleState.value,
                                        priceState.value.toInt(),
                                        categoryState.value,
                                        selectedDate
                                    )
                                )
                                selectedDate = 0L
                                titleState.value = ""
                                categoryState.value = ""
                                priceState.value = ""
                                coroutineScope.launch {
                                    modalSheetState.hide()
                                }
                                keyboardController?.hide()
                            }
                        }
                    ) {
                        Text(text = "Save")
                    }
                    Button(
                        onClick = {
                            coroutineScope.launch { modalSheetState.hide() }
                            keyboardController?.hide()
                        }
                    ) {
                        Text(text = "Cancel")
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Expense App")
                    },
                    actions = {
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "more vert"
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier,
                    backgroundColor = Purple500,
                    onClick = {
                        coroutineScope.launch {
                            if (modalSheetState.isVisible)
                                modalSheetState.hide()
                            else
                                modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn() {
                    items(expenses) { item ->
                        ExpenseRow(item, onRemove = {
                            expenses.remove(it)
                        })
                    }
                }
            }
        }
    }

}

//@Preview
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("SimpleDateFormat")
@Composable
fun ExpenseRow(
    expense: Expense = Expense(1, "Title", 100, "Food", System.currentTimeMillis()),
    onRemove: (Expense) -> Unit
) {
    val context = LocalContext.current
    var showCustomDialog by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(8.dp)
        .combinedClickable(onLongClick = {
            showCustomDialog = !showCustomDialog
        }) {}, elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = expense.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "$" + expense.amount.toString())
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = expense.category)
                val sdf = SimpleDateFormat("yyyy/MM/dd")
                Text(text = sdf.format(Timestamp(expense.date)))
            }
        }

    }

    if (showCustomDialog) {
        CustomAlertDialog(
            onDismiss = {
                showCustomDialog = !showCustomDialog
            },
            onYesAction = {
                onRemove(expense)
                showCustomDialog = !showCustomDialog
            }
        )
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview
@Composable
fun DefaultPreview() {
    ExpenseTracker()
}