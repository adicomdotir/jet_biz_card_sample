package ir.adicom.jedbizcard.features.authentication.domain.use_cases

import ir.adicom.jedbizcard.features.authentication.domain.models.User
import ir.adicom.jedbizcard.features.authentication.domain.repositories.UserRepository
import javax.inject.Inject

class InsertUser @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User) {
        return userRepository.insertUser(user)
    }
}