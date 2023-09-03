package ir.adicom.jedbizcard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.adicom.jedbizcard.domain.User
import ir.adicom.jedbizcard.domain.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) {
    val user: LiveData<User?> = MutableLiveData<User?>()
    init {
        GlobalScope.launch {
            user.apply {
                userRepository.getUser(1)
            }
        }

    }

    fun getUser() {
        GlobalScope.launch {
            user.apply {
                userRepository.getUser(1)
            }
        }
    }
}