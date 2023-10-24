package com.cretihoy.wordminded2.presentation.components.switch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.theme.Shapes

@Composable
fun SwitchView(
    model: SwitchModel? = null,
    modifier: Modifier = Modifier
) {
    model?.textAttr?.let {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(Shapes.medium)
                .clickable { model.isChecked.value = !model.isChecked.value },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = it),
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = model.fontSize.value.sp
            )
            SpacerView(Modifier.weight(1f))
            Switch(
                checked = model.isChecked.value,
                onCheckedChange = { model.isChecked.value = it }
            )
        }
    }
}