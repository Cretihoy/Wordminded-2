package com.cretihoy.wordminded2.presentation.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cretihoy.wordminded2.extensions.openUsersScreen
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.counter.CounterView
import com.cretihoy.wordminded2.presentation.components.dialog.DialogView
import com.cretihoy.wordminded2.presentation.components.rotate.RotateView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.switch.SwitchView
import com.cretihoy.wordminded2.presentation.components.text.TextView
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    navController: NavHostController
) {
    Box {
        RotateView(
            header = {
                TextView(
                    modifier = it,
                    model = viewModel.settingsTitle
                )
            },
            content = {
                Column(
                    modifier = it
                ) {
                    SpacerView(Modifier.size(spacingLarge))
                    SwitchView(viewModel.orientationSettingsSwitch)
                    SpacerView()
                    SwitchView(viewModel.themeSettingsSwitch)
                    SpacerView()
                    SwitchView(viewModel.infinityGameSwitch)
                    SpacerView()
                    CounterView(viewModel.counterModel)
                    SpacerView()
                    ButtonView(viewModel.manageUsersButtonModel,
                        Modifier.fillMaxWidth(),
                        clickAction = {
                            navController.openUsersScreen()
                        }
                    )
                    SpacerView()
                    ButtonView(viewModel.resetSettingsButtonModel,
                        Modifier.fillMaxWidth(),
                        clickAction = {
                            viewModel.isShown.value = true
                        }
                    )
                    SpacerView(Modifier.size(spacingLarge))
                }
            }
        )
        DialogView(
            viewModel.isShown,
            model = viewModel.dialog,
            leftClick = {
                viewModel.isShown.value = false
            }, rightClick = {
                viewModel.onResetSettingsClicked()
                viewModel.isShown.value = false
            }
        )
    }
}
