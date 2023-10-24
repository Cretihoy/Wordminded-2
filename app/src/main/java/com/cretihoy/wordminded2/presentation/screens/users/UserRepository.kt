package com.cretihoy.wordminded2.presentation.screens.users

import com.cretihoy.wordminded2.data.db.UserDao
import com.cretihoy.wordminded2.presentation.components.user.UserModel
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val database: UserDao,
    private val mapper: UserMapper
) {

    suspend fun getUsers(): List<UserModel> {
        return database.getAll().map { mapper.map(it) }
    }

    suspend fun addUser(model: UserModel) {
        val user = mapper.map(model)
        database.add(user)
    }

    suspend fun removeUser(model: UserModel) {
        val user = mapper.map(model)
        database.remove(user)
    }
}
