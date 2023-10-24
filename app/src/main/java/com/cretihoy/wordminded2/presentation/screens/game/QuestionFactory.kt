package com.cretihoy.wordminded2.presentation.screens.game

import com.cretihoy.wordminded2.R
import com.cretihoy.wordminded2.data.Storage
import javax.inject.Inject

class QuestionFactory
@Inject constructor(
    private val storage: Storage
) {

    private val infinityLetterList = getLetterList().toList()
    private val infinityTaskList = getTaskList().toList()
    private var regularLetterList = (getLetterList() + getLetterList()).toMutableList()
    private var regularTaskList = getTaskList().toMutableList()

    private fun getLetterList(): List<Int> {
        return listOf(
            R.string.letter_01,
            R.string.letter_02,
            R.string.letter_03,
            R.string.letter_04,
            R.string.letter_05,
            R.string.letter_06,
            R.string.letter_07,
            R.string.letter_08,
            R.string.letter_09,
            R.string.letter_10,
            R.string.letter_11,
            R.string.letter_12,
            R.string.letter_13,
            R.string.letter_14,
            R.string.letter_15,
            R.string.letter_16,
            R.string.letter_17,
            R.string.letter_18,
            R.string.letter_19,
            R.string.letter_20,
            R.string.letter_21,
            R.string.letter_22,
            R.string.letter_23,
            R.string.letter_24,
            R.string.letter_25,
            R.string.letter_26
        ).shuffled()
    }

    private fun getTaskList(): List<Int> {
        return listOf(
            R.string.task_01,
            R.string.task_02,
            R.string.task_03,
            R.string.task_04,
            R.string.task_05,
            R.string.task_06,
            R.string.task_07,
            R.string.task_08,
            R.string.task_09,
            R.string.task_10,
            R.string.task_11,
            R.string.task_12,
            R.string.task_13,
            R.string.task_14,
            R.string.task_15,
            R.string.task_16,
            R.string.task_17,
            R.string.task_18,
            R.string.task_19,
            R.string.task_20,
            R.string.task_21,
            R.string.task_22,
            R.string.task_23,
            R.string.task_24,
            R.string.task_25,
            R.string.task_26,
            R.string.task_27,
            R.string.task_28,
            R.string.task_29,
            R.string.task_30,
            R.string.task_31,
            R.string.task_32,
            R.string.task_33,
            R.string.task_34,
            R.string.task_35,
            R.string.task_36,
            R.string.task_37,
            R.string.task_38,
            R.string.task_39,
            R.string.task_40,
            R.string.task_41,
            R.string.task_42,
            R.string.task_43,
            R.string.task_44,
            R.string.task_45,
            R.string.task_46,
            R.string.task_47,
            R.string.task_48,
            R.string.task_49,
            R.string.task_50,
            R.string.task_51,
            R.string.task_52,
        ).shuffled()
    }

    private fun getRandomInfinityTask(): Int {
        return infinityTaskList.random()
    }

    private fun getRandomInfinityLetter(): Int {
        return infinityLetterList.random()
    }

    private fun getRandomRegularTask(): Int? {
        val task: Int? = regularTaskList.randomOrNull()
        val index = regularTaskList.indexOf(task)
        if (index >= 0) regularTaskList.removeAt(index)
        return task
    }

    private fun getRandomRegularLetter(): Int? {
        val letter = regularLetterList.randomOrNull()
        val index = regularLetterList.indexOf(letter)
        if (index >= 0) regularLetterList.removeAt(index)
        return letter
    }

    fun resetLists() {
        regularLetterList = (getLetterList() + getLetterList()).toMutableList()
        regularTaskList = getTaskList().toMutableList()
    }

    fun getRandomTask(): Int? {
        return if (storage.isInfinityGame.value)
            getRandomInfinityTask()
        else
            getRandomRegularTask()

    }

    fun getRandomLetter(): Int? {
        return if (storage.isInfinityGame.value)
            getRandomInfinityLetter()
        else
            getRandomRegularLetter()

    }
}