package com.cretihoy.wordminded2.presentation.screens.game

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel
@Inject constructor(
    private val factory: GameModelFactory
) : ViewModel() {

    val endGameModel: EndGameModel = factory.getEndGameModel()
    val gameSide = mutableStateOf(factory.getGameSideModel())
    val task = gameSide.value.task?.textAttr
    val letter = gameSide.value.letter?.textAttr

    fun onClick() {
        factory.reloadTasks()
    }

    init {
        newGame()
    }

    fun newGame() {
        factory.startGame()
    }
}