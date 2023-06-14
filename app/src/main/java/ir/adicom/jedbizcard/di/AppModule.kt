package ir.adicom.jedbizcard.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.adicom.jedbizcard.database.AppDatabase
import ir.adicom.jedbizcard.database.UserDao
import ir.adicom.jedbizcard.features.authentication.data.data_sources.DataSource
import ir.adicom.jedbizcard.features.authentication.data.repositories.UserRepositoryImpl
import ir.adicom.jedbizcard.features.authentication.domain.repositories.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun providesUserRepository(dataSource: DataSource): UserRepository {
        return UserRepositoryImpl(dataSource = dataSource)
    }
}