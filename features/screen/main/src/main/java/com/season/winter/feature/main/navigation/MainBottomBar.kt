package com.season.winter.feature.main.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.color.base.Palette
import com.season.winter.feature.main.navigation.style.AddItemBasicStyle
import com.season.winter.feature.main.navigation.style.AddItemHorizonAnimatedStyle


@Composable
fun MainBottomBar(navController: NavHostController) {

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Row(
            modifier = Modifier
                .background(Palette.Gray2.composeColor)
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavGraph.items.forEach { screen ->
                AddItemBasicStyle( // or AddItemAnimatedStyle(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewMainBottomNavigation() {
    ComposeCatchBottleTheme {
        val navController = rememberNavController()

        Column {
            Row {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    Row(
                        modifier = Modifier
                            .background(Palette.Gray2.composeColor)
                            .fillMaxWidth()
                        ,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NavGraph.items.forEach { screen ->
                            AddItemBasicStyle(
                                screen = screen,
                                currentDestination = currentDestination,
                                navController = navController
                            )
                        }
                    }
                }
            }

            Row {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    Row(
                        modifier = Modifier
                            .background(Palette.Gray2.composeColor)
                            .fillMaxWidth()
                        ,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NavGraph.items.forEach { screen ->
                            AddItemHorizonAnimatedStyle(
                                screen = screen,
                                currentDestination = currentDestination,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
