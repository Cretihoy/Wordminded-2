package com.cretihoy.wordminded2.presentation.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import com.cretihoy.wordminded2.presentation.theme.Shapes
import com.cretihoy.wordminded2.presentation.theme.spacingMedium

@Composable
fun ModalView(
    isShown: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    isCancelable: Boolean = true,
    action: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    if (isShown.value) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        if (isCancelable) {
                            isShown.value = false
                        }
                    }
                    .fillMaxSize()
                    .alpha(0.1f)
                    .background(MaterialTheme.colorScheme.onBackground))
            Column(
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment,
                modifier = modifier
                    .padding(spacingMedium)
                    .clip(Shapes.large)
                    .clickable { action.invoke() }
                    .background(MaterialTheme.colorScheme.background)
                    .padding(spacingMedium)
            ) {
                content.invoke(this)
            }
        }
    }
}