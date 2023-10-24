package com.cretihoy.wordminded2.presentation.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cretihoy.wordminded2.data.Storage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject constructor(
    private val factory: SettingsModelFactory,
    private val storage: Storage
) : ViewModel() {

    val isShown = mutableStateOf(false)
    val settingsTitle by lazy { factory.getTitleSettingsModel() }
    val orientationSettingsSwitch by lazy { factory.getOrientationSwitchSettingsModel() }
    val themeSettingsSwitch by lazy { factory.getThemeSwitchSettingsModel() }
    val infinityGameSwitch by lazy { factory.getInfinityGameModel() }
    val counterModel by lazy { factory.getCounterModel() }
    val manageUsersButtonModel by lazy { factory.getManageUsersButtonModel() }
    val resetSettingsButtonModel by lazy { factory.getResetSettingsModel() }
    val dialog by lazy { factory.getDialogModel() }

    fun onResetSettingsClicked() {
        storage.resetSettings()
    }
}