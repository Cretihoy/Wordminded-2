package com.cretihoy.wordminded.compose.presentation.screen.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.cretihoy.wordminded2.presentation.components.gameside.GameSideView
import com.cretihoy.wordminded2.presentation.components.rotate.RotateView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.screens.end.EndGameScreen
import com.cretihoy.wordminded2.presentation.screens.game.GameViewModel
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun GameScreen(
    viewModel: GameViewModel
) {
    Column(
        modifier = Modifier
            .padding(spacingLarge)
            .fillMaxSize()
    ) {
        if (viewModel.task?.value != null && viewModel.letter?.value != null) {
            RotateView(
                header = {
                    GameSideView(viewModel.gameSide.value,
                        Modifier
                            .weight(1f)
                            .rotate(180f),
                        actionLetter = { viewModel.onClick() },
                        actionTask = { viewModel.onClick() }
                    )
                },
                content = {
                    SpacerView()
                    GameSideView(
                        viewModel.gameSide.value, Modifier.weight(1f),
                        actionLetter = { viewModel.onClick() },
                        actionTask = { viewModel.onClick() }
                    )
                })
        } else {
            EndGameScreen(viewModel.endGameModel) {
                viewModel.newGame()
            }
        }
    }
}