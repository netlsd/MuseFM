package com.netlsd.musefm

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument

data class NavArgument(val name: String) {
    val navArg = navArgument(name) { nullable = true }
}

sealed class Screen(
    val routeId: String,
    val args: List<NavArgument> = emptyList(),
    @StringRes val titleId: Int,
    val icon: ImageVector,
    val argRoute: String = generateRouteWithArgPlaceholders(routeId, args),
    val navArgs: List<NamedNavArgument> = args.map { it.navArg }
) {
    object Home: Screen(routeId = "home", titleId = R.string.nav_home, icon = Icons.Rounded.Home)
    object History: Screen(routeId = "History", titleId = R.string.nav_history, icon = Icons.Rounded.History)
    object Settings: Screen(routeId = "Settings", titleId = R.string.nav_settings, icon = Icons.Rounded.Settings)
}

fun generateRouteWithArgPlaceholders(route: String, args: List<NavArgument>) =
    route + if (args.isNotEmpty()) args.joinToString("/", "/") {
        "{${it.name}}"
    } else ""