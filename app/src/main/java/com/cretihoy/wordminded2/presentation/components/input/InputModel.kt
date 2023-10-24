package com.cretihoy.wordminded2.presentation.components.input

import androidx.compose.runtime.MutableState
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.text.TextModel

data class InputModel(
    val title: TextModel? = null,
    val text: MutableState<String>? = null,
    val button: ButtonModel? = null
)