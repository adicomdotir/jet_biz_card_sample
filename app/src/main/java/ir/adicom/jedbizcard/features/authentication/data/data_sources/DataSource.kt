package ir.adicom.jedbizcard.features.authentication.data.data_sources

import ir.adicom.jedbizcard.database.UserDao
import ir.adicom.jedbizcard.database.UserEntity
import javax.inject.Inject

class DataSource @Inject constructor(private val userDao: UserDao) {
    suspend fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
    }
}