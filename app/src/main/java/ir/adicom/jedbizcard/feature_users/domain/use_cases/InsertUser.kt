package ir.adicom.jedbizcard.feature_users.domain.use_cases

import ir.adicom.jedbizcard.feature_users.domain.model.User
import ir.adicom.jedbizcard.feature_users.domain.repository.UserRepository
import javax.inject.Inject

class InsertUser @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}