package com.cretihoy.wordminded2.presentation.screens.users

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cretihoy.wordminded2.presentation.components.input.InputModel
import com.cretihoy.wordminded2.presentation.components.user.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel
@Inject constructor(
    private val factory: UserModelFactory,
    private val repository: UserRepository
) : ViewModel() {

    val dialogModel by lazy { factory.getDialogModel() }
    val titleModel by lazy { factory.getTitleModel() }
    val users = mutableStateListOf<UserModel>()
    val newUserButtonModel by lazy { factory.getNewUserButtonModel() }

    var currentUser: UserModel? = null

    val editInputModel: MutableState<InputModel?> = mutableStateOf(null)
    val addingInputModel by lazy { factory.getAddingInputModel() }

    val isDialogShown: MutableState<Boolean> = mutableStateOf(false)
    val isShownEdit = mutableStateOf(false)
    val isShownAdding = mutableStateOf(false)

    fun addUser(name: String) {
        viewModelScope.launch {
            val user = factory.getUserModel(name)
            users.add(user)
            repository.addUser(user)
        }
    }

    fun loadUsers() {
        viewModelScope.launch {
            users.addAll(repository.getUsers())
        }
    }

    fun onRemoveClicked() {
        viewModelScope.launch {
            currentUser?.let { model ->
                repository.removeUser(model)
                users.remove(model)
                isDialogShown.value = false
            }
        }
    }

    fun onEditClicked(model: UserModel) {
        currentUser = model
        isShownEdit.value = true
        editInputModel.value = factory.getAddingInputModel(model.nameButton.text.orEmpty())
    }

    fun onEditFinished(name: String) {
        viewModelScope.launch {
            currentUser?.let { model ->
                val newButton = model.nameButton.copy(text = name)
                val newModel = model.copy(nameButton = newButton)
                users.remove(model)
                users.add(newModel)
                repository.addUser(newModel)
            }
        }
    }
}