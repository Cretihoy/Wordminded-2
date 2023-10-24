package com.cretihoy.wordminded2.presentation.screens.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.dialog.DialogView
import com.cretihoy.wordminded2.presentation.components.input.InputView
import com.cretihoy.wordminded2.presentation.components.rotate.RotateView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.text.TextView
import com.cretihoy.wordminded2.presentation.components.user.UserView
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun UsersScreen(
    viewModel: UsersViewModel
) {
    viewModel.loadUsers()
    Box {
        RotateView(
            header = { modifier ->
                TextView(
                    model = viewModel.titleModel,
                    modifier = modifier.fillMaxWidth()
                )
            },
            content = { modifier ->
                Column(modifier = modifier) {
                    SpacerView(Modifier.size(spacingLarge))
                    for (it in viewModel.users) {
                        UserView(
                            model = it,
                            editAction = { model ->
                                viewModel.onEditClicked(model)
                            },
                            removeAction = { model ->
                                viewModel.isDialogShown.value = true
                                viewModel.currentUser = model
                            }
                        )
                        SpacerView()
                    }
                    ButtonView(
                        viewModel.newUserButtonModel,
                        modifier = Modifier.fillMaxWidth(),
                        clickAction = {
                            viewModel.isShownAdding.value = true
                        })
                    SpacerView(Modifier.size(spacingLarge))
                }
            }
        )
        viewModel.editInputModel.value?.let { model ->
            InputView(
                isShown = viewModel.isShownEdit,
                model = model,
                action = { name ->
                    viewModel.onReplaceUserClicked(name)
                }
            )
        }
        InputView(
            isShown = viewModel.isShownAdding,
            model = viewModel.addingInputModel,
            action = { name ->
                viewModel.onAddUserClicked(name)
            }
        )
        DialogView(
            viewModel.isDialogShown,
            model = viewModel.dialogModel,
            leftClick = {
                viewModel.isDialogShown.value = false
            }, rightClick = {
                viewModel.onRemoveClicked()
            }
        )
    }
}