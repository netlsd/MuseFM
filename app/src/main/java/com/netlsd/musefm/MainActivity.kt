package com.netlsd.musefm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.netlsd.musefm.components.BottomNavigationBar
import com.netlsd.musefm.screens.ContentRoute
import com.netlsd.musefm.ui.MuseFMTheme
import com.netlsd.musefm.util.route

private val mainScreens = listOf(
    Screen.Home,
    Screen.History,
    Screen.Settings
)

class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainContent()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainContent() {
    MuseFMTheme {
        val navController = rememberNavController()
        val snackHost = remember { SnackbarHostState() }
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        Scaffold(
            scaffoldState = rememberScaffoldState(snackbarHostState = snackHost),
            bottomBar = {
                if (mainScreens.map { it.routeId }
                        .contains(navBackStackEntry?.route()) || navBackStackEntry == null) {
                    BottomNavigationBar(
                        currentRoute = navBackStackEntry?.route(),
                        screens = mainScreens
                    ) {
                        navController.popBackStack(
                            navController.graph.startDestination,
                            false
                        )
                        navController.navigate(it.routeId)
                    }
                }
            }) {
            ContentRoute(navController = navController)
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}