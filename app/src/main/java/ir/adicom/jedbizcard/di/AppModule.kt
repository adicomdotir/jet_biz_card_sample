package ir.adicom.jedbizcard.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.adicom.jedbizcard.feature_users.data.repository.UserRepositoryImpl
import ir.adicom.jedbizcard.feature_users.data.source.local.UserDatabase
import ir.adicom.jedbizcard.feature_users.domain.repository.UserRepository
import ir.adicom.jedbizcard.utils.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDatabase(application: Application) = Room.databaseBuilder(
        application,
        UserDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }
}