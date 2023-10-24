package com.cretihoy.wordminded2.presentation.components.counter

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.theme.spacingSmall

@Composable
fun CounterView(
    model: CounterModel? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        model?.let { model ->
            model.textAttr?.let { text ->
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = text),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = model.fontSize.value.sp
                )
            }
            SpacerView(Modifier.weight(1f))
            model.leftButton?.let { buttonModel ->
                ButtonView(
                    model = buttonModel,
                    clickAction = { buttonModel.fontSize.value-- }
                )
            }
            Text(
                modifier = Modifier.padding(spacingSmall),
                text = model.fontSize.value.toInt().toString(),
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = model.fontSize.value.sp
            )
            model.rightButton?.let { buttonModel ->
                ButtonView(
                    model = buttonModel,
                    clickAction = { buttonModel.fontSize.value++ }
                )
            }
        }
    }
}