package com.cretihoy.wordminded2.presentation.components.button

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

data class ButtonModel(
    val icon: ImageVector? = null,
    val fontSize: MutableState<Float>,
    val text: String? = null,
    val textAttr: MutableState<Int?> = mutableStateOf(null),
    val isSecondary: Boolean = false
)