package ir.adicom.jedbizcard.data

import ir.adicom.jedbizcard.domain.User
import ir.adicom.jedbizcard.domain.UserRepository

class UserRepositoryImpl: UserRepository {
    override suspend fun getUser(id: Long): User? {
        return try {
            User(id = 1, name = "John Doe", email = "john_doe@example.com")
        } catch (e: Exception) {
            null
        }
    }
}