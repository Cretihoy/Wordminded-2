package com.cretihoy.wordminded2.presentation.screens.users

import androidx.compose.runtime.mutableStateListOf
import com.cretihoy.wordminded2.data.db.UserDao
import com.cretihoy.wordminded2.extensions.replace
import com.cretihoy.wordminded2.presentation.components.user.UserModel
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val database: UserDao,
    private val mapper: UserMapper,
    private val factory: UserModelFactory
) {

    val users = mutableStateListOf<UserModel>()

    suspend fun loadUsers() {
        if (users.isEmpty()) {
            users.addAll(database.getAll().map { mapper.map(it) })
        }
    }

    suspend fun addUser(name: String) {
        val user = factory.getUserModel(name)
        users.add(user)
        database.add(mapper.map(user))
    }

    suspend fun removeUser(user: UserModel) {
        users.remove(user)
        database.remove(mapper.map(user))
    }

    suspend fun replaceUser(remove: UserModel, put: UserModel) {
        users.replace(remove, put)
        database.add(mapper.map(put))
    }
}