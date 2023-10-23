package com.cretihoy.wordminded2.presentation.screens.timer

import com.cretihoy.wordminded2.R
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.components.text.TextModel
import javax.inject.Inject

class TimerModelFactory
@Inject constructor(
    private val storage: Storage,
) {

    fun getTitleModel(): TextModel {
        return TextModel(
            fontSize = storage.fontSize,
            textAttr = R.string.timer_dialog,
            isTitle = false
        )
    }

    fun getCounterModel(counter: Int? = null): TextModel? {
        return counter?.let {
            TextModel(
                fontSize = storage.fontSize,
                text = counter.toString(),
                isTitle = true
            )
        }
    }
}
