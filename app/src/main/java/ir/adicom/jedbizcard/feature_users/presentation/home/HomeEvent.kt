package ir.adicom.jedbizcard.feature_users.presentation.home

import ir.adicom.jedbizcard.feature_users.domain.model.User

sealed class HomeEvent {
    data class DeleteUser(val user: User) : HomeEvent()
}
