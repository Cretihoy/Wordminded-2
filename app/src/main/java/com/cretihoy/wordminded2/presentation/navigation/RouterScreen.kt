package com.cretihoy.wordminded2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cretihoy.wordminded.compose.presentation.screen.game.GameScreen
import com.cretihoy.wordminded.compose.presentation.screen.menu.MenuViewModel
import com.cretihoy.wordminded2.presentation.screens.users.UsersScreen
import com.cretihoy.wordminded2.presentation.screens.users.UsersViewModel
import com.cretihoy.wordminded2.presentation.navigation.NavRoutes.MenuNavRoute
import com.cretihoy.wordminded2.presentation.screens.game.GameViewModel
import com.cretihoy.wordminded2.presentation.screens.menu.MenuScreen
import com.cretihoy.wordminded2.presentation.screens.rules.RulesScreen
import com.cretihoy.wordminded2.presentation.screens.rules.RulesViewModel
import com.cretihoy.wordminded2.presentation.screens.settings.SettingsScreen
import com.cretihoy.wordminded2.presentation.screens.settings.SettingsViewModel

@Composable
fun RouterScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MenuNavRoute.route,
    ) {

        composable(MenuNavRoute.route) {
            val viewModel = hiltViewModel<MenuViewModel>()
            MenuScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(NavRoutes.GameNavRoute.route) {
            val viewModel = hiltViewModel<GameViewModel>()
            GameScreen(
                viewModel = viewModel,
            )
        }

        composable(NavRoutes.RulesNavRoute.route) {
            val viewModel = hiltViewModel<RulesViewModel>()
            RulesScreen(
                viewModel = viewModel
            )
        }

        composable(NavRoutes.SettingsNavRoute.route) {
            val viewModel = hiltViewModel<SettingsViewModel>()
            SettingsScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(NavRoutes.UsersNavRoute.route) {
            val viewModel = hiltViewModel<UsersViewModel>()
            UsersScreen(
                viewModel = viewModel
            )
        }
    }
}