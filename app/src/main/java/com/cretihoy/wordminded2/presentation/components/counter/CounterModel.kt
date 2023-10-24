package com.cretihoy.wordminded2.presentation.components.counter

import androidx.compose.runtime.MutableState
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel

data class CounterModel(
    val fontSize: MutableState<Float>,
    val textAttr: Int? = null,
    val leftButton: ButtonModel? = null,
    val rightButton: ButtonModel? = null,
)