package com.cretihoy.wordminded2.presentation.screens.settings

import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.R
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.components.button.ButtonModel
import com.cretihoy.wordminded2.presentation.components.counter.CounterModel
import com.cretihoy.wordminded2.presentation.components.dialog.DialogModel
import com.cretihoy.wordminded2.presentation.components.image.ImageModel
import com.cretihoy.wordminded2.presentation.components.switch.SwitchModel
import com.cretihoy.wordminded2.presentation.components.text.TextModel
import javax.inject.Inject

class SettingsModelFactory
@Inject constructor(
    private val storage: Storage
) {

    fun getTitleSettingsModel(): TextModel {
        return TextModel(
            fontSize = storage.fontSize,
            textAttr = R.string.settings_title,
            isTitle = true,
            image = ImageModel(
                src = R.drawable.logo,
                srcAlt = R.drawable.logo_inverted,
                isInverted = storage.isAltTheme
            )
        )
    }

    fun getOrientationSwitchSettingsModel(): SwitchModel {
        return SwitchModel(
            fontSize = storage.fontSize,
            textAttr = R.string.settings_switch_change_orientation,
            isChecked = storage.isHorizontal,
            isSecondary = true

        )
    }

    fun getThemeSwitchSettingsModel(): SwitchModel {
        return SwitchModel(
            fontSize = storage.fontSize,
            textAttr = R.string.settings_switch_change_theme,
            isChecked = storage.isAltTheme,
            isSecondary = true
        )
    }

    fun getInfinityGameModel(): SwitchModel {
        return SwitchModel(
            fontSize = storage.fontSize,
            textAttr = R.string.settings_switch_change_infinity,
            isChecked = storage.isInfinityGame,
            isSecondary = true
        )
    }

    fun getCounterModel(): CounterModel {
        return CounterModel(
            fontSize = storage.fontSize,
            textAttr = R.string.settings_counter_change_font_size,
            leftButton = ButtonModel(
                fontSize = storage.fontSize,
                textAttr = mutableStateOf(R.string.settings_counter_minus),
                isSecondary = true
            ),
            rightButton = ButtonModel(
                fontSize = storage.fontSize,
                textAttr = mutableStateOf(R.string.settings_counter_plus)
            )
        )
    }

    fun getResetSettingsModel(): ButtonModel {
        return ButtonModel(
            fontSize = storage.fontSize,
            textAttr = mutableStateOf(R.string.settings_button_reset),
            isSecondary = true
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

    fun getManageUsersButtonModel(): ButtonModel {
        return ButtonModel(
            fontSize = storage.fontSize,
            textAttr = mutableStateOf(R.string.settings_button_manage_users)
        )
    }
}