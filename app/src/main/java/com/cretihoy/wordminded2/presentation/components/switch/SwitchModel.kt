package com.cretihoy.wordminded2.presentation.components.switch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class SwitchModel(
    val fontSize: MutableState<Float>,
    val textAttr: Int? = null,
    var isChecked: MutableState<Boolean> = mutableStateOf(false)
)