package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.R
import com.example.ui.components.BottomNav
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PlaceholderScreen
import com.example.ui.theme.NexoBg

object NexoRoutes {
    const val HOME = "home"
    const val SCAN = "scan"
    const val CONFIRM = "confirm"
    const val PROCESSING = "processing"
    const val RESULT = "result"
    const val WALLET = "wallet"
    const val ASSET = "asset"
    const val FUNDS = "funds"
    const val RECEIVE = "receive"
    const val ACTIVITY = "activity"
    const val ACTIVITY_DETAIL = "activity-detail"
    const val PROFILE = "profile"
}

@Composable
fun NexoApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: NexoRoutes.HOME

    val showBottomNav = currentRoute in setOf(
        NexoRoutes.HOME,
        NexoRoutes.WALLET,
        NexoRoutes.SCAN,
        NexoRoutes.ACTIVITY,
        NexoRoutes.PROFILE
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NexoBg)
    ) {
        NavHost(
            navController = navController,
            startDestination = NexoRoutes.HOME,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(NexoRoutes.HOME) {
                HomeScreen(
                    onNavigate = { route ->
                        navController.navigate(route)
                    }
                )
            }

            composable(NexoRoutes.SCAN) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_scan),
                    onBackClick = { navController.navigate(NexoRoutes.HOME) },
                    hasBottomNav = true
                )
            }

            composable(NexoRoutes.CONFIRM) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_confirm),
                    onBackClick = { navController.navigate(NexoRoutes.SCAN) }
                )
            }

            composable(NexoRoutes.PROCESSING) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_processing),
                    showCompactBrand = true
                )
            }

            composable(NexoRoutes.RESULT) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_result),
                    onBackClick = { navController.navigate(NexoRoutes.HOME) }
                )
            }

            composable(NexoRoutes.WALLET) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_wallet),
                    showCompactBrand = true,
                    hasBottomNav = true
                )
            }

            composable(NexoRoutes.ASSET) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_asset),
                    onBackClick = { navController.navigate(NexoRoutes.WALLET) }
                )
            }

            composable(NexoRoutes.FUNDS) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_funds),
                    onBackClick = { navController.navigate(NexoRoutes.WALLET) }
                )
            }

            composable(NexoRoutes.RECEIVE) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_receive),
                    onBackClick = { navController.navigate(NexoRoutes.WALLET) }
                )
            }

            composable(NexoRoutes.ACTIVITY) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_activity),
                    showCompactBrand = true,
                    hasBottomNav = true
                )
            }

            composable(NexoRoutes.ACTIVITY_DETAIL) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_activity_detail),
                    onBackClick = { navController.navigate(NexoRoutes.ACTIVITY) }
                )
            }

            composable(NexoRoutes.PROFILE) {
                PlaceholderScreen(
                    title = stringResource(R.string.title_profile),
                    showCompactBrand = true,
                    hasBottomNav = true
                )
            }
        }

        if (showBottomNav) {
            BottomNav(
                currentRoute = currentRoute,
                onNavigate = { targetRoute ->
                    if (targetRoute != currentRoute) {
                        navController.navigate(targetRoute) {
                            popUpTo(NexoRoutes.HOME) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
