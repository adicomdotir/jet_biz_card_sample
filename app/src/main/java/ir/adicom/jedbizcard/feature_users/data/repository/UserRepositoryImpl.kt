package ir.adicom.jedbizcard.feature_users.data.repository

import ir.adicom.jedbizcard.feature_users.data.source.local.dao.UserDao
import ir.adicom.jedbizcard.feature_users.domain.model.User
import ir.adicom.jedbizcard.feature_users.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dao: UserDao) : UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return dao.getUsers()
    }

    override suspend fun getUserById(id: Int): User? {
        return dao.getUserById(id)
    }

    override suspend fun insertUser(user: User) {
        return dao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        return dao.deleteUser(user)
    }
}