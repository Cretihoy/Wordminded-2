package com.cretihoy.wordminded2.presentation.theme

import androidx.lifecycle.ViewModel
import com.cretihoy.wordminded2.data.Storage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel
@Inject constructor(
    val storage: Storage
) : ViewModel() {

    val isAltTheme = storage.isAltTheme
}