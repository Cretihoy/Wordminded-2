package com.cretihoy.wordminded2.presentation.screens.menu

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cretihoy.wordminded2.presentation.screens.menu.MenuModelFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel
@Inject constructor(
    private val factory: MenuModelFactory
) : ViewModel() {

    val isShown = mutableStateOf(false)
    val imageModel by lazy { factory.getImageModel() }
    val startButtonModel by lazy { factory.getStartButtonModel() }
    val rulesButtonModel by lazy { factory.getRulesButtonModel() }
    val settingsButtonModel by lazy { factory.getSettingsButtonModel() }
}