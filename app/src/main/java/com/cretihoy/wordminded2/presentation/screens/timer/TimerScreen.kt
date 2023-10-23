package com.cretihoy.wordminded2.presentation.screens.timer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cretihoy.wordminded.compose.presentation.screen.timer.TimerViewModel
import com.cretihoy.wordminded2.extensions.openGameScreen
import com.cretihoy.wordminded2.presentation.components.modal.ModalView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.components.text.TextView

@Composable
fun TimerScreen(
    isShown: MutableState<Boolean>,
    navController: NavHostController,
    modifier: Modifier
) {
    val viewModel = hiltViewModel<TimerViewModel>()
    if (viewModel.canGoNext.value) {
        navController.openGameScreen()
        isShown.value = false
        viewModel.canGoNext.value = false
    }
    viewModel.loadGameScreen(isShown)

    ModalView(
        isShown = isShown,
        modifier = modifier
    ) {
        TextView(viewModel.titleModel)
        SpacerView(viewModel.titleModel, viewModel.counterModel)
        TextView(
            model = viewModel.counterModel.value,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}