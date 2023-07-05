package ir.adicom.jedbizcard.domain

interface UserRepository {
    suspend fun getUser(id: Long): User?
}