package com.cretihoy.wordminded2.presentation.components.button

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cretihoy.wordminded2.presentation.theme.EMPTY_STRING
import com.cretihoy.wordminded2.presentation.theme.Shapes
import com.cretihoy.wordminded2.presentation.theme.spacingSmall

@Composable
fun ButtonView(
    model: ButtonModel? = null,
    modifier: Modifier = Modifier,
    clickAction: () -> Unit = {}
) {
    model?.let { it ->
        Button(
            onClick = clickAction,
            modifier = modifier
                .sizeIn(
                    minWidth = 56.dp,
                    minHeight = 56.dp
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (it.isSecondary)
                    MaterialTheme.colorScheme.secondary
                else
                    MaterialTheme.colorScheme.primary,
            ),
            shape = Shapes.medium,
        ) {
            it.icon?.let { image ->
                Icon(
                    imageVector = image,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    contentDescription = EMPTY_STRING
                )
            }
            val text = it.text ?: it.textAttr.value?.let { stringResource(it) }
            text?.let {
                Text(
                    modifier = Modifier.padding(spacingSmall),
                    text = it,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = model.fontSize.value.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}