package com.netlsd.musefm.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.netlsd.musefm.Screen

private val BottomNavigationElevation = 8.dp
private val BottomNavigationHeight = 56.dp

@Composable
fun CustomBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationElevation,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation
    ) {
        Row(
            modifier.fillMaxWidth().preferredHeight(BottomNavigationHeight),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

@Composable
fun BottomNavigationBar(
    screens: List<Screen>,
    currentRoute: String?,
    onClicked: (Screen) -> Unit
) {
    CustomBottomNavigation(
        backgroundColor = MaterialTheme.colors.surface
    ) {
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon) },
                label = {
                    Text(
                        text = stringResource(id = screen.titleId),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                selected = currentRoute == screen.routeId,
                onClick = {
                    if (currentRoute == screen.routeId) return@BottomNavigationItem
                    onClicked(screen)
                }
            )
        }
    }
}