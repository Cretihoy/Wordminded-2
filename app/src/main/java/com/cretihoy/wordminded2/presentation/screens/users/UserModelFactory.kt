package com.cretihoy.wordminded2.presentation.screens.users

import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.R
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.dialog.DialogModel
import com.cretihoy.wordminded2.presentation.components.image.ImageModel
import com.cretihoy.wordminded2.presentation.components.input.InputModel
import com.cretihoy.wordminded2.presentation.components.text.TextModel
import com.cretihoy.wordminded2.presentation.components.user.UserModel
import com.cretihoy.wordminded2.presentation.theme.EMPTY_STRING
import com.cretihoy.wordminded2.presentation.theme.icAdd
import com.cretihoy.wordminded2.presentation.theme.icCheck
import com.cretihoy.wordminded2.presentation.theme.icDelete
import javax.inject.Inject

class UserModelFactory
@Inject constructor(
    private val storage: Storage
) {

    fun getAddingInputModel(name: String = EMPTY_STRING): InputModel {
        return InputModel(
            title = TextModel(
                fontSize = storage.fontSize,
                textAttr = R.string.add_new_name_title
            ),
            text = mutableStateOf(name),
            button = ButtonModel(
                fontSize = storage.fontSize,
                icon = icCheck
            )
        )
    }

    fun getNewUserButtonModel(): ButtonModel {
        return ButtonModel(
            fontSize = storage.fontSize,
            icon = icAdd,
            textAttr = mutableStateOf(R.string.manage_users_button_add_new_name)
        )
    }

    fun getTitleModel(): TextModel {
        return TextModel(
            fontSize = storage.fontSize,
            textAttr = R.string.manage_users_title,
            isTitle = true,
            image = ImageModel(
                src = R.drawable.logo,
                srcAlt = R.drawable.logo_inverted,
                isInverted = storage.isAltTheme
            )
        )
    }

    fun getUserModel(name: String): UserModel {
        return UserModel(
            id = System.currentTimeMillis() + name.hashCode(),
            score = 0,
            nameButton = ButtonModel(
                fontSize = storage.fontSize,
                text = name
            ),
            removeButton = ButtonModel(
                fontSize = storage.fontSize,
                icon = icDelete,
                isSecondary = true
            )
        )
    }

    fun getDialogModel(): DialogModel {
        return DialogModel(
            title = TextModel(
                fontSize = storage.fontSize,
                textAttr = R.string.reset_settings_title,
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
}
