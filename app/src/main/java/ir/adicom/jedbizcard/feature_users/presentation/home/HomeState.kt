package ir.adicom.jedbizcard.feature_users.presentation.home

import ir.adicom.jedbizcard.feature_users.domain.model.User

data class HomeState(
    val users: List<User> = emptyList()
)