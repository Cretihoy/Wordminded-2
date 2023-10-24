package com.cretihoy.wordminded2.presentation.screens.rules

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RulesViewModel
@Inject constructor(
    private val factory: RulesModelFactory
) : ViewModel() {

    val rulesTitle by lazy { factory.getTitleRulesModel() }
    val rulesOne by lazy { factory.getOneRulesModel() }
    val rulesTwo by lazy { factory.getTwoRules2Model() }
    val rulesThree by lazy { factory.getThreeRules3Model() }
}