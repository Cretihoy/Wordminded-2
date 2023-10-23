package com.cretihoy.wordminded2.presentation.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ImageView(
    model: ImageModel? = null,
    modifier: Modifier = Modifier
) {
    model?.src?.let {
        Image(
            modifier = modifier
                .fillMaxWidth(),
            contentDescription = null,
            painter = painterResource(
                if (model.isInverted.value) {
                    model.srcAlt
                } else {
                    model.src
                }
            )
        )
    }
}
