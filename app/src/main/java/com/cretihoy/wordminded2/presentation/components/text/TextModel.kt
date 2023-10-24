package com.cretihoy.wordminded2.presentation.components.text

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.presentation.components.image.ImageModel

data class TextModel(
    val fontSize: MutableState<Float>,
    val text: String? = null,
    val value: MutableState<Int?> = mutableStateOf(null),
    val textAttr: Int? = null,
    val isTitle: Boolean = false,
    val image: ImageModel? = null
)