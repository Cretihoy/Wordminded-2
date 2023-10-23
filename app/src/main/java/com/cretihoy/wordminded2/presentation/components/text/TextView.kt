package com.cretihoy.wordminded2.presentation.components.text

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.cretihoy.wordminded2.presentation.components.image.ImageView
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun TextView(
    model: TextModel? = null,
    modifier: Modifier = Modifier
) {
    val textFromAttr = model?.textAttr?.let { stringResource(it) }
    val text = model?.text ?: textFromAttr

    text?.let {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            if (model!!.isTitle) {
                ImageView(
                    model = model.image,
                    modifier = Modifier
                        .scale(1.5f)
                        .blur(spacingLarge)
                )
            }
            Text(
                modifier = if (model.isTitle)
                    Modifier
                else
                    Modifier,
                textAlign = TextAlign.Center,
                text = if (model.isTitle)
                    it.uppercase()
                else
                    it,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = if (model.isTitle) {
                    (model.fontSize.value * 2).sp
                } else {
                    model.fontSize.value.sp
                },
                fontWeight = if (model.isTitle)
                    FontWeight.Bold
                else
                    FontWeight.Normal
            )
        }
    }
}