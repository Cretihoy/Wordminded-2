package com.cretihoy.wordminded2.presentation.components.user

import androidx.compose.runtime.MutableState
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel

data class UserModel(
    val id: Long,
    var score: MutableState<Int?>,
    val nameButton: ButtonModel,
    val removeButton: ButtonModel
)