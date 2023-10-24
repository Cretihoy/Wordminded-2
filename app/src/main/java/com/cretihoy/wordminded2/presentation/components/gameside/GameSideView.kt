package com.cretihoy.wordminded2.presentation.components.gameside

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.text.TextView
import com.cretihoy.wordminded2.presentation.theme.EMPTY_STRING
import com.cretihoy.wordminded2.presentation.theme.Shapes
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun GameSideView(
    icon: ImageVector? = null,
    model: GameSideModel? = null,
    modifier: Modifier = Modifier,
    actionTask: () -> Unit = {},
    actionLetter: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        GameSideLayout(
            model = model
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
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = EMPTY_STRING,
                modifier = Modifier
                    .scale(2f)
                    .clip(Shapes.large)
                    .background(MaterialTheme.colorScheme.onError)
                    .padding(spacingLarge)
            )
        }
    }
}

@Composable
fun GameSideLayout(
    model: GameSideModel? = null,
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit = {}
) {
    if (model?.isHorizontal?.value == true) {
        Column(modifier = modifier) {
            Row(modifier = Modifier.weight(1f)) {
                content.invoke(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )
            }
            TextView(model.name)
        }
    } else {
        Column(modifier = modifier) {
            content.invoke(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
            TextView(model?.name)
        }
    }
}