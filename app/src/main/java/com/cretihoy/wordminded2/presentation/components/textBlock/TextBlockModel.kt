package com.cretihoy.wordminded2.presentation.components.textBlock

import androidx.compose.runtime.MutableState

data class TextBlockModel(
    val fontSize: MutableState<Float>,
    val textAttr: Int? = null,
    val isSecondary: Boolean = false
)