package ir.adicom.jedbizcard.feature_users.presentation.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.adicom.jedbizcard.R
import ir.adicom.jedbizcard.feature_users.presentation.edit.components.UserInputText
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
) {
    val nameState = viewModel.userName.value
    val lastNameState = viewModel.userLastName.value
    val ageState = viewModel.userAge.value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.SaveUser -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            EditTopBar()
        },
        bottomBar = {
            EditBottomBar {
                viewModel.onEvent(EditEvent.InsertUser)
            }
        }
    ) {
        EditContent(
            name = nameState.value,
            lastName = lastNameState.value,
            age = ageState.value,
            onEvent = {
                viewModel.onEvent(it)
            }
        )
    }
}

@Composable
fun EditContent(
    name: String,
    lastName: String,
    age: String,
    onEvent: (EditEvent) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        UserInputText(
            text = name,
            hint = "User Name",
            onTextChange = {
                onEvent(EditEvent.EnteredName(it))
            }
        )
        UserInputText(
            text = lastName,
            hint = "User Last Name",
            onTextChange = {
                onEvent(EditEvent.EnteredLastName(it))
            }
        )
        UserInputText(
            text = age,
            hint = "User Age",
            onTextChange = {
                onEvent(EditEvent.EnteredAge(it))
            }
        )
    }
}

@Composable
fun EditTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.add_user),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertUser: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = { onInsertUser() }) {
        Text("Save")
    }
}