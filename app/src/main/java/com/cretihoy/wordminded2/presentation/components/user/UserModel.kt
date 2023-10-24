package com.cretihoy.wordminded2.presentation.components.user

import com.cretihoy.wordminded2.presentation.components.button.ButtonModel

data class UserModel(
    val id: Long,
    val score: Long,
    val nameButton: ButtonModel,
    val removeButton: ButtonModel
)