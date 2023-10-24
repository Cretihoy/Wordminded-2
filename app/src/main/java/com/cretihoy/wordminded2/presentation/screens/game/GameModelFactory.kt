package com.cretihoy.wordminded2.presentation.screens.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.R
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.dialog.DialogModel
import com.cretihoy.wordminded2.presentation.components.gameside.GameSideModel
import com.cretihoy.wordminded2.presentation.components.image.ImageModel
import com.cretihoy.wordminded2.presentation.components.text.TextModel
import com.cretihoy.wordminded2.presentation.screens.end.EndGameModel
import javax.inject.Inject

class GameModelFactory
@Inject constructor(
    private val factory: QuestionFactory,
    private val storage: Storage
) {

    private var task: MutableState<Int?> = mutableStateOf(factory.getRandomTask())
    private var letter: MutableState<Int?> = mutableStateOf(factory.getRandomLetter())

    fun getDialogModel(): DialogModel {
        return DialogModel(
            title = TextModel(
                fontSize = storage.fontSize,
                text = "Is it correct?",
            ),
            leftButton = ButtonModel(
                fontSize = storage.fontSize,
                textAttr = mutableStateOf(R.string.reset_settings_button_no),
                isSecondary = true
            ),
            rightButton = ButtonModel(
                fontSize = storage.fontSize,
                textAttr = mutableStateOf(R.string.reset_settings_button_yes)
            )
        )
    }

    fun getBottomGameSideModel(): GameSideModel {
        val nameModel = TextModel(
            text = storage.secondPlayer.value?.nameButton?.text,
            value = storage.secondPlayer.value?.score ?: mutableStateOf(null),
            fontSize = storage.fontSize,
            isTitle = true
        )
        return getGameSideModel().copy(name = nameModel)
    }

    fun getTopGameSideModel(): GameSideModel {
        val nameModel = TextModel(
            text = storage.firstPlayer.value?.nameButton?.text,
            value = storage.firstPlayer.value?.score ?: mutableStateOf(null),
            fontSize = storage.fontSize,
            isTitle = true
        )
        return getGameSideModel().copy(name = nameModel)
    }

    private fun getGameSideModel(): GameSideModel {
        return GameSideModel(
            task = getTaskModel(),
            letter = getLetterModel(),
            isHorizontal = storage.isHorizontal,
            isInfinityGame = storage.isInfinityGame
        )
    }

    private fun getLetterModel(): ButtonModel {
        return ButtonModel(
            fontSize = storage.fontSize,
            textAttr = letter,
            isSecondary = true
        )
    }

    private fun getTaskModel(): ButtonModel {
        return ButtonModel(
            fontSize = storage.fontSize,
            textAttr = task,
        )
    }

    fun startGame() {
        factory.resetLists()
        reloadTasks()
    }

    fun reloadTasks() {
        task.value = factory.getRandomTask()
        letter.value = factory.getRandomLetter()
    }

    fun getEndGameModel(): EndGameModel {
        return EndGameModel(
            title = TextModel(
                fontSize = storage.fontSize,
                textAttr = R.string.game_end_title,
                isTitle = true,
                image = ImageModel(
                    src = R.drawable.logo,
                    srcAlt = R.drawable.logo_inverted,
                    isInverted = storage.isAltTheme
                )
            ),
            button = ButtonModel(
                fontSize = storage.fontSize,
                textAttr = mutableStateOf(R.string.game_end_button)
            )
        )
    }
}