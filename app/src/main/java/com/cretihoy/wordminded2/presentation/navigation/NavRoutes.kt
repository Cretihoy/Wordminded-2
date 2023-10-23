package com.cretihoy.wordminded2.presentation.navigation

sealed class NavRoutes(val route: String) {

    //menu
    object MenuNavRoute : NavRoutes("MenuNavRote")

    //game
    object GameNavRoute : NavRoutes("GameNavRote")

    //rules
    object RulesNavRoute : NavRoutes("RulesNavRote")

    //settings
    object SettingsNavRoute : NavRoutes("SettingsNavRote")

    // user settings
    object UsersNavRoute : NavRoutes("UsersNavRoute")
}