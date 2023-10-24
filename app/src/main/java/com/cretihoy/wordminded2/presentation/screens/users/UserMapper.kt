package com.cretihoy.wordminded2.presentation.screens.users

import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.data.db.UserEntity
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.user.UserModel
import com.cretihoy.wordminded2.presentation.theme.icDelete
import javax.inject.Inject

class UserMapper @Inject constructor(
    private val storage: Storage
) {

    fun map(model: UserModel): UserEntity {
        return UserEntity(
            id = model.id,
            name = model.nameButton.text.orEmpty(),
            score = model.score.value ?: 0
        )
    }

    fun map(user: UserEntity): UserModel {
        return UserModel(
            id = user.id,
            score = mutableStateOf(user.score),
            nameButton = ButtonModel(
                fontSize = storage.fontSize,
                text = user.name
            ),
            removeButton = ButtonModel(
                fontSize = storage.fontSize,
                icon = icDelete,
                isSecondary = true
            )
        )
    }
}
