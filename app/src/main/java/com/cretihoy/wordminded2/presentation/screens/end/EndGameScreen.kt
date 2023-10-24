package com.cretihoy.wordminded2.presentation.screens.end

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.rotate.RotateView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.text.TextView

@Composable
fun EndGameScreen(
    model: EndGameModel,
    clickAction: () -> Unit = {}
) {
    RotateView(
        header = {
            TextView(
                model.title,
                modifier = it
            )
        },
        content = {
            SpacerView()
            ButtonView(
                model = model.button,
                modifier = Modifier.fillMaxWidth(),
                clickAction = clickAction
            )
        })
}