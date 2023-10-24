package com.cretihoy.wordminded2.presentation.components.dialog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.modal.ModalView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.text.TextView
import com.cretihoy.wordminded2.presentation.theme.minWidth

@Composable
fun DialogView(
    isShown: MutableState<Boolean>,
    model: DialogModel? = null,
    modifier: Modifier = Modifier,
    isCancelable: Boolean = true,
    leftClick: () -> Unit = {},
    rightClick: () -> Unit = {}
) {
    model?.let {
        ModalView(
            isShown = isShown,
            modifier = modifier,
            isCancelable = isCancelable,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                TextView(model.title)
                SpacerView(model.title, model.description)
                TextView(model.description)
                SpacerView()
                Row {
                    ButtonView(
                        model.leftButton,
                        clickAction = leftClick,
                        modifier = Modifier.sizeIn(minWidth = minWidth)
                    )
                    SpacerView(model.leftButton, model.rightButton)
                    ButtonView(
                        model.rightButton,
                        clickAction = rightClick,
                        modifier = Modifier.sizeIn(minWidth = minWidth)
                    )
                }
            })
    }
}