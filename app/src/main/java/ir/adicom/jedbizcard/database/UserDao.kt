package ir.adicom.jedbizcard.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userEntity: UserEntity)
}