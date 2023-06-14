package ir.adicom.jedbizcard.features.authentication.presentetion.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.adicom.jedbizcard.features.authentication.domain.models.User
import ir.adicom.jedbizcard.features.authentication.domain.use_cases.InsertUser
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val insertUser: InsertUser) : ViewModel() {
    init {
        viewModelScope.launch {
            insertUser(User(id = 0, username = "", password = ""))
        }
    }
}