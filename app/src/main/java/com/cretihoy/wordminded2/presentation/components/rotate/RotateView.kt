package com.cretihoy.wordminded2.presentation.components.rotate

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun RotateView(
    header: @Composable (modifier: Modifier) -> Unit,
    content: @Composable (modifier: Modifier) -> Unit,
) {
    var orientation by remember { mutableStateOf(Configuration.ORIENTATION_PORTRAIT) }

    val configuration = LocalConfiguration.current
    LaunchedEffect(configuration) {
        snapshotFlow { configuration.orientation }.collect { orientation = it }
    }
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column {
            header.invoke(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            content.invoke(
                modifier = Modifier
                    .padding(horizontal = spacingLarge)
                    .verticalScroll(rememberScrollState())
            )
        }
    } else {
        Row {
            header.invoke(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            content.invoke(
                Modifier
                    .padding(horizontal = spacingLarge)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .verticalScroll(rememberScrollState())
            )
        }
    }
}

@Preview
@Composable
fun PreviewRotateView() {
    RotateView(header = {
        Box(
            modifier = it
                .background(Color.Cyan)
                .fillMaxWidth()
        )
    }, content = {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .height(120.dp)
                .fillMaxWidth()
        )
    })
}