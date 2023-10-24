package com.cretihoy.wordminded2.presentation.components.textBlock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.cretihoy.wordminded2.presentation.theme.Shapes
import com.cretihoy.wordminded2.presentation.theme.spacingMedium

@Composable
fun TextBlockView(
    model: TextBlockModel? = null,
    modifier: Modifier = Modifier
) {
    model?.let {
        Box(
            modifier = modifier.clip(Shapes.large)
        ) {
            it.textAttr?.let { text ->
                Text(
                    modifier = Modifier
                        .background(if (model.isSecondary) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary)
                        .padding(spacingMedium),
                    text = stringResource(id = text),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = model.fontSize.value.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}