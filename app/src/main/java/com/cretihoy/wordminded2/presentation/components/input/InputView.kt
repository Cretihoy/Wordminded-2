package com.cretihoy.wordminded2.presentation.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.modal.ModalView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.text.TextView
import com.cretihoy.wordminded2.presentation.theme.EMPTY_STRING
import com.cretihoy.wordminded2.presentation.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputView(
    isShown: MutableState<Boolean>,
    model: InputModel,
    action: (String) -> Unit = {}
) {
    ModalView(isShown = isShown) {
        TextView(model.title)
        SpacerView()
        Row {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .clip(Shapes.medium)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onBackground,
                        Shapes.medium
                    ),
                value = model.text?.value.orEmpty(),
                onValueChange = {
                    model.text?.value = it
                }
            )
            SpacerView(model.text, model.button)
            ButtonView(
                model = model.button,
                clickAction = {
                    if (model.text?.value.orEmpty().isNotEmpty()) {
                        action.invoke(model.text?.value.orEmpty())
                        model.text?.value = EMPTY_STRING
                        isShown.value = false
                    }
                })
        }
    }
}