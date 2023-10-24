package com.cretihoy.wordminded2.presentation.components.user

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView

@Composable
fun UserView(
    model: UserModel,
    removeAction: (UserModel) -> Unit = {},
    editAction: (UserModel) -> Unit = {}
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        ButtonView(
            modifier = Modifier.weight(1f),
            model = model.nameButton,
            clickAction = { editAction.invoke(model) }
        )
        SpacerView()
        ButtonView(
            model = model.removeButton,
            clickAction = { removeAction.invoke(model) }
        )
    }
}