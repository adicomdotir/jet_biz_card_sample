package ir.adicom.jedbizcard.features.authentication.domain.repositories

import ir.adicom.jedbizcard.features.authentication.domain.models.User

interface UserRepository {
    suspend fun insertUser(user: User)
}