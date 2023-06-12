package ir.adicom.jedbizcard.features.authentication.data.repositories

import ir.adicom.jedbizcard.database.UserEntity
import ir.adicom.jedbizcard.features.authentication.data.data_sources.DataSource
import ir.adicom.jedbizcard.features.authentication.domain.models.User
import ir.adicom.jedbizcard.features.authentication.domain.repositories.UserRepository

class UserRepositoryImpl(private val dataSource: DataSource) : UserRepository {
    override suspend fun insertUser(user: User) {
        dataSource.insertUser(
            UserEntity(
                id = user.id,
                username = user.username,
                password = user.password
            )
        )
    }
}