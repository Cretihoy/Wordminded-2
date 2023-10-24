package com.cretihoy.wordminded2.data.db

import androidx.room.*

@Dao
interface UserDao {

    @Transaction
    @Query("SELECT * FROM UserEntity")
    suspend fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id == :id LIMIT 1")
    suspend fun getById(id: Long): UserEntity

    @Query("SELECT * FROM UserEntity WHERE name LIKE :name LIMIT 1")
    suspend fun getByName(name: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addList(vararg users: UserEntity)

    @Delete
    suspend fun remove(user: UserEntity)
}