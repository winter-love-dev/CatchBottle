package com.season.winter.feature.main.navigation.style

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.season.winter.compose.icon.CBIcon
import com.season.winter.compose.text.CBText
import com.season.winter.designsystem.size.CBSize
import com.season.winter.designsystem.typography.CBTypography
import com.season.winter.feature.main.navigation.NavGraph

@Composable
fun RowScope.AddItemBasicStyle(
    screen: NavGraph,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (selected) screen.focusedColor else screen.outFocusColor

    BottomNavigationItem(
        icon = {
            CBIcon(
                painterResource(screen.icon),
                CBSize.L,
                modifier = Modifier.clip(CircleShape),
                tint = background,
            )
        },
        label = {
            CBText(
                text = screen.route,
                style = CBTypography.CaptionS,
                extraStyle = LocalTextStyle.current.copy(
                    color = background
                )
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route) {
                // 스크린 중복 스택이 쌓이지 않게 상태를 저장하기
                popUpTo(id = navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true // 스크린 복사, 다중 생성 방지
                restoreState = true // 이전 스크린의 상태 복원
            }
        }
    )
}
