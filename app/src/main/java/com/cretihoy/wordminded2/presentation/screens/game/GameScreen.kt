package com.cretihoy.wordminded2.presentation.screens.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.cretihoy.wordminded2.presentation.components.dialog.DialogView
import com.cretihoy.wordminded2.presentation.components.gameside.GameSideView
import com.cretihoy.wordminded2.presentation.components.rotate.RotateView
import com.cretihoy.wordminded2.presentation.components.spacer.SpacerView
import com.cretihoy.wordminded2.presentation.screens.end.EndGameScreen
import com.cretihoy.wordminded2.presentation.theme.spacingLarge

@Composable
fun GameScreen(
    viewModel: GameViewModel
) {
    Box {
        Column(
            modifier = Modifier
                .padding(spacingLarge)
                .fillMaxSize()
        ) {
            if (viewModel.task?.value != null && viewModel.letter?.value != null) {
                RotateView(
                    header = {
                        GameSideView(
                            icon = viewModel.iconHeader.value,
                            model = viewModel.topGameSide.value,
                            modifier = Modifier
                                .weight(1f)
                                .rotate(180f),
                            actionLetter = { viewModel.onHeaderClick() },
                            actionTask = { viewModel.onHeaderClick() }
                        )
                    },
                    content = {
                        SpacerView()
                        GameSideView(
                            icon = viewModel.iconContent.value,
                            model = viewModel.bottomGameSide.value,
                            modifier = Modifier.weight(1f),
                            actionLetter = {
                                viewModel.onContentClick()
                            },
                            actionTask = {
                                viewModel.onContentClick()
                            }
                        )
                    })

            } else {
                EndGameScreen(viewModel.endGameModel) {
                    viewModel.newGame()
                }
            }
        }
        DialogView(
            isShown = viewModel.isDialogShown,
            model = viewModel.dialogModel,
            modifier = Modifier.rotate(viewModel.userSide.value.rotate),
            isCancelable = false,
            leftClick = {
                viewModel.failAnswer()
            },
            rightClick = {
                viewModel.successAnswer()
            }
        )
    }
}