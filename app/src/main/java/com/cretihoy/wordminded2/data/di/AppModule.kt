package com.cretihoy.wordminded2.data.di

import android.content.Context
import androidx.room.Room
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.data.db.UserDao
import com.cretihoy.wordminded2.data.db.UserDatabase
import com.cretihoy.wordminded2.presentation.screens.users.UserMapper
import com.cretihoy.wordminded2.presentation.screens.users.UserModelFactory
import com.cretihoy.wordminded2.presentation.screens.users.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDao(
        db: UserDatabase
    ): UserDao {
        return db.userDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java, "database-name"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(
        database: UserDao,
        mapper: UserMapper,
        factory: UserModelFactory
    ): UserRepository {
        return UserRepository(
            database,
            mapper,
            factory
        )
    }

    @Provides
    @Singleton
    fun provideStorage(): Storage {
        return Storage()
    }
}