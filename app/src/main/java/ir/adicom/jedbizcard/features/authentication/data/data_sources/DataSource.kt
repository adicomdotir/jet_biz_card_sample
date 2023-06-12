package ir.adicom.jedbizcard.features.authentication.data.data_sources

import ir.adicom.jedbizcard.database.UserDao
import ir.adicom.jedbizcard.database.UserEntity

class DataSource(private val userDao: UserDao) {
    suspend fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
    }
}