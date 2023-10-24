package com.cretihoy.wordminded2.presentation.components.users

import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.R
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.text.TextModel
import javax.inject.Inject

class UserPickerFactory
@Inject constructor(
    private val storage: Storage
) {

    fun getTitleModel(): TextModel {
        return TextModel(
            fontSize = storage.fontSize,
            textAttr = R.string.who_are_play,
            isTitle = true
        )
    }

    fun getNextButtonModel(): ButtonModel {
        return ButtonModel(
            fontSize = storage.fontSize,
            textAttr = mutableStateOf(R.string.go),
            isSecondary = true
        )
    }

}