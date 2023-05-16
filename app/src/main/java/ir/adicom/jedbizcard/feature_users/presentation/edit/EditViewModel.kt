package ir.adicom.jedbizcard.feature_users.presentation.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.feature_users.domain.model.User
import ir.adicom.jedbizcard.feature_users.domain.use_cases.GetUser
import ir.adicom.jedbizcard.feature_users.domain.use_cases.InsertUser
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val getUser: GetUser,
    private val insertUser: InsertUser,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _userName = mutableStateOf(TextFieldState())
    val userName: State<TextFieldState> = _userName

    private val _userLastName = mutableStateOf(TextFieldState())
    val userLastName: State<TextFieldState> = _userLastName

    private val _userAge = mutableStateOf(TextFieldState())
    val userAge: State<TextFieldState> = _userAge

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentUserId: Int? = null

    init {
        savedStateHandle.get<Int>("userId")?.let { userId ->
            if (userId != -1) {
                viewModelScope.launch {
                    getUser(userId)?.also { user ->
                        currentUserId = user.id
                        _userName.value = userName.value.copy(
                            value = user.name
                        )
                        _userLastName.value = userLastName.value.copy(
                            value = user.lastName
                        )
                        _userAge.value = userAge.value.copy(
                            value = user.age
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: EditEvent) {
        when (event) {
            is EditEvent.EnteredAge -> {
                _userAge.value = userAge.value.copy(value = event.value)
            }
            is EditEvent.EnteredLastName -> {
                _userLastName.value = userLastName.value.copy(value = event.value)
            }
            is EditEvent.EnteredName -> {
                _userName.value = userName.value.copy(value = event.value)
            }
            EditEvent.InsertUser -> {
                viewModelScope.launch {
                    insertUser(User(
                        name = userName.value.value,
                        lastName = userLastName.value.value,
                        age = userAge.value.value,
                        id = currentUserId
                    ))
                    _eventFlow.emit(UiEvent.SaveUser)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveUser: UiEvent()
    }
}
