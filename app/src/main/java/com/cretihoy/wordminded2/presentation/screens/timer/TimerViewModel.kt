package com.cretihoy.wordminded2.presentation.screens.timer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cretihoy.wordminded2.presentation.components.text.TextModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val SECOND_IN_MILLS = 1000L
private const val SECONDS = 3

@HiltViewModel
class TimerViewModel
@Inject constructor(
    private val factory: TimerModelFactory
) : ViewModel() {

    private var job: Job? = null

    val titleModel = factory.getTitleModel()
    val counterModel: MutableState<TextModel?> = mutableStateOf(null)

    val canGoNext = mutableStateOf(false)

    fun loadGameScreen(isShown: MutableState<Boolean>) {
        job = viewModelScope.launch {
            if (isShown.value) {
                doCount()
            } else {
                job?.cancel()
            }
        }
    }

    private suspend fun doCount() {
        for (number in SECONDS downTo 1) {
            counterModel.value = factory.getCounterModel(number)
            delay(SECOND_IN_MILLS)
        }
        canGoNext.value = true
    }
}