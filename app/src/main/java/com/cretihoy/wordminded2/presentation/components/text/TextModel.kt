package com.cretihoy.wordminded2.presentation.components.text

import androidx.compose.runtime.MutableState
import com.cretihoy.wordminded2.presentation.components.image.ImageModel

data class TextModel(
    val fontSize: MutableState<Float>,
    val text: String? = null,
    val textAttr: Int? = null,
    val isTitle: Boolean = false,
    val image: ImageModel? = null
)