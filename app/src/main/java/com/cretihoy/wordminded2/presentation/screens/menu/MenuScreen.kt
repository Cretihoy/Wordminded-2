package com.cretihoy.wordminded2.presentation.screens.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cretihoy.wordminded2.presentation.screens.timer.TimerScreen
import com.cretihoy.wordminded2.extensions.openRulesScreen
import com.cretihoy.wordminded2.extensions.openSettingsScreen
import com.cretihoy.wordminded2.presentation.components.button.ButtonView
import com.cretihoy.wordminded2.presentation.components.image.ImageView
import com.cretihoy.wordminded2.presentation.components.rotate.RotateView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun MenuScreen(
    navController: NavHostController,
    viewModel: MenuViewModel
) {
    Box {
        RotateView(
            header = {
                ImageView(
                    modifier = it,
                    model = viewModel.imageModel
                )
            },
            content = {
                Column(
                    modifier = it
                ) {
                    SpacerView(Modifier.size(spacingLarge))
                    ButtonView(
                        viewModel.startButtonModel,
                        Modifier.fillMaxWidth(),
                        clickAction = { viewModel.isShown.value = true }
                    )
                    SpacerView()
                    ButtonView(
                        viewModel.rulesButtonModel,
                        Modifier.fillMaxWidth(),
                        clickAction = { navController.openRulesScreen() }
                    )
                    SpacerView()
                    ButtonView(
                        viewModel.settingsButtonModel,
                        Modifier.fillMaxWidth(),
                        clickAction = { navController.openSettingsScreen() }
                    )
                    SpacerView(Modifier.size(spacingLarge))
                }
            }
        )
        TimerScreen(
            isShown = viewModel.isShown,
            navController = navController,
            modifier = Modifier
        )
    }
}