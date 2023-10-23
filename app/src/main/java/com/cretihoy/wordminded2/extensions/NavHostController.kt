package com.cretihoy.wordminded2.extensions

import androidx.navigation.NavHostController
import com.cretihoy.wordminded2.presentation.navigation.NavRoutes

fun NavHostController.openGameScreen() {
    this.navigate(NavRoutes.GameNavRoute.route)
}

fun NavHostController.openRulesScreen() {
    this.navigate(NavRoutes.RulesNavRoute.route)
}

fun NavHostController.openSettingsScreen() {
    this.navigate(NavRoutes.SettingsNavRoute.route)
}

fun NavHostController.openUsersScreen() {
    this.navigate(NavRoutes.UsersNavRoute.route)
}