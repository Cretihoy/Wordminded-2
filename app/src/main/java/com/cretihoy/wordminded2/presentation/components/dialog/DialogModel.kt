package com.cretihoy.wordminded2.presentation.components.dialog

import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.text.TextModel

data class DialogModel(
    val title: TextModel? = null,
    val description: TextModel? = null,
    val leftButton: ButtonModel? = null,
    val rightButton: ButtonModel? = null,
)