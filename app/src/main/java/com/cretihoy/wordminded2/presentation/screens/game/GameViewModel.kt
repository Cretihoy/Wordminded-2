package com.cretihoy.wordminded2.presentation.screens.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.screens.end.EndGameModel
import com.cretihoy.wordminded2.presentation.theme.icCheck
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel
@Inject constructor(
    private val factory: GameModelFactory,
    private val storage: Storage
) : ViewModel() {

    val isDialogShown = mutableStateOf(false)
    val dialogModel = factory.getDialogModel()
    val userSide = mutableStateOf(UserSide.CONTENT)

    val iconHeader: MutableState<ImageVector?> = mutableStateOf(null)
    val iconContent: MutableState<ImageVector?> = mutableStateOf(null)

    val endGameModel: EndGameModel = factory.getEndGameModel()
    val topGameSide = mutableStateOf(factory.getTopGameSideModel())
    val bottomGameSide = mutableStateOf(factory.getBottomGameSideModel())

    val task = topGameSide.value.task?.textAttr
    val letter = topGameSide.value.letter?.textAttr

    init {
        newGame()
    }

    fun onHeaderClick() {
        userSide.value = UserSide.HEADER
        isDialogShown.value = true
        iconHeader.value = icCheck
    }

    fun onContentClick() {
        userSide.value = UserSide.CONTENT
        isDialogShown.value = true
        iconContent.value = icCheck
    }

    fun successAnswer() {
        isDialogShown.value = false
        factory.reloadTasks()
        increaseScore()
        resetIcons()
    }

    private fun increaseScore() {
        if (storage.firstPlayer.value != null && storage.secondPlayer.value != null) {
            when (userSide.value) {
                UserSide.HEADER -> increaseValue(storage.firstPlayer.value?.score)
                UserSide.CONTENT -> increaseValue(storage.secondPlayer.value?.score)
            }
        }
    }

    private fun increaseValue(value: MutableState<Int?>?) {
        value?.let { state ->
            state.value?.let {
                state.value = it + 1
            }
        }
    }

    fun failAnswer() {
        isDialogShown.value = false
        factory.reloadTasks()
        resetIcons()
    }

    fun resetIcons() {
        iconHeader.value = null
        iconContent.value = null
    }

    fun newGame() = factory.startGame()
}