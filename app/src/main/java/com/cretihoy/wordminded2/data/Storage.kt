package com.cretihoy.wordminded2.data

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cretihoy.wordminded2.presentation.components.user.UserModel
import javax.inject.Inject

private const val PREFERENCES_KEY = "Wordminded"
private const val IS_HORIZONTAL_KEY = "isHorizontal"
private const val IS_THEME_KEY = "isTheme"
private const val FONT_SIZE_KEY = "fontSize"
private const val INFINITY_GAME_KEY = "infinityGame"

class Storage
@Inject constructor() {

    val firstPlayer: MutableState<UserModel?> = mutableStateOf(null)
    val secondPlayer: MutableState<UserModel?> = mutableStateOf(null)

    var savedActivity: Activity? = null
    val fontSize = mutableStateOf(18f)
    val isHorizontal = mutableStateOf(false)
    val isAltTheme = mutableStateOf(false)
    val isInfinityGame = mutableStateOf(false)

    fun loadSettings(activity: Activity) {
        savedActivity = activity
        val preferences = activity.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
        isHorizontal.value = preferences.getBoolean(IS_HORIZONTAL_KEY, false)
        isAltTheme.value = preferences.getBoolean(IS_THEME_KEY, false)
        isInfinityGame.value = preferences.getBoolean(INFINITY_GAME_KEY, false)
        fontSize.value = preferences.getFloat(FONT_SIZE_KEY, 18f)
    }

    fun saveSettings() {
        savedActivity?.let {
            val preferences = it.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
            preferences.edit().putBoolean(IS_HORIZONTAL_KEY, isHorizontal.value).apply()
            preferences.edit().putBoolean(IS_THEME_KEY, isAltTheme.value).apply()
            preferences.edit().putBoolean(INFINITY_GAME_KEY, isInfinityGame.value).apply()
            preferences.edit().putFloat(FONT_SIZE_KEY, fontSize.value).apply()
        }
    }

    fun resetSettings() {
        fontSize.value = 18f
        isHorizontal.value = false
        isAltTheme.value = false
        isInfinityGame.value = false
        saveSettings()
    }
}