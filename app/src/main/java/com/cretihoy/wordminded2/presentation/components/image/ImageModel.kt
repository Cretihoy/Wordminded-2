package com.cretihoy.wordminded2.presentation.components.image

import androidx.compose.runtime.MutableState

data class ImageModel(
    val src: Int,
    val srcAlt: Int,
    val isInverted: MutableState<Boolean>
)