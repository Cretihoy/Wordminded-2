package com.cretihoy.wordminded2.presentation.components.gameside

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView

@Composable
fun GameSideView(
    model: GameSideModel? = null,
    modifier: Modifier = Modifier,
    actionTask: () -> Unit = {},
    actionLetter: () -> Unit = {}
) {
    GameLayout(
        model = model,
        modifier = modifier
    ) {
        ButtonView(
            model = model?.task,
            clickAction = actionTask,
            modifier = it
        )
        SpacerView()
        ButtonView(
            model = model?.letter,
            clickAction = actionLetter,
            modifier = it
        )
    }
}

@Composable
fun GameLayout(
    model: GameSideModel? = null,
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit = {}
) {
    if (model?.isHorizontal?.value == true) {
        Row(modifier = modifier) {
            content.invoke(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
        }
    } else {
        Column(modifier = modifier) {
            content.invoke(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}