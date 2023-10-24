package com.cretihoy.wordminded2.presentation.screens.menu

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.screens.users.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel
@Inject constructor(
    private val factory: MenuModelFactory,
    private val storage: Storage,
    private val repository: UserRepository
) : ViewModel() {

    val isInfinityGame = storage.isInfinityGame
    val users = repository.users

    val isUsersShown = mutableStateOf(false)
    val isCounterShown = mutableStateOf(false)
    val imageModel by lazy { factory.getImageModel() }
    val startButtonModel by lazy { factory.getStartButtonModel() }
    val rulesButtonModel by lazy { factory.getRulesButtonModel() }
    val settingsButtonModel by lazy { factory.getSettingsButtonModel() }

    fun loadUsers() {
        viewModelScope.launch { repository.loadUsers() }
    }
}