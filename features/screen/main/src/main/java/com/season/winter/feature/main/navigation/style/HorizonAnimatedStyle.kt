package com.season.winter.feature.main.navigation.style

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.season.winter.compose.box.CBBox
import com.season.winter.compose.icon.CBIcon
import com.season.winter.compose.text.CBText
import com.season.winter.designsystem.color.base.Palette
import com.season.winter.designsystem.size.CBSize
import com.season.winter.designsystem.typography.CBTypography
import com.season.winter.feature.main.navigation.NavGraph

@Composable
fun RowScope.AddItemHorizonAnimatedStyle(
    screen: NavGraph,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (selected) screen.focusedColor else screen.outFocusColor
//    val contentColor = if (selected) screen.focusedColor else screen.outFocusColor

    Row(
        modifier = Modifier
            .background(Palette.Gray2.composeColor)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CBBox(
            modifier = Modifier
                .height(CBSize.X2l.dp)
                .clip(CircleShape)
                .background(background)
                .clickable(onClick = {
                    navController.navigate(screen.route) {

                        // 스크린 중복 스택이 쌓임 방지, 상태 저장하기
                        popUpTo(id = navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true // 스크린 복사, 다중 생성 방지
                        restoreState = true // 이전 스크린의 상태 복원
                    }
                })
        ) {
            Row(
                modifier = Modifier
                    .padding(CBSize.Xs.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CBIcon(
                    painter = painterResource(screen.icon),
                    //                tint = if (selected) screen.focusedColor else screen.outFocusColor
                )
                AnimatedVisibility(visible = selected) {
                    CBText(
                        text = screen.route,
                        style = CBTypography.CaptionS,
                        extraStyle = LocalTextStyle.current.copy(
                            color = Palette.Gray5.composeColor
                        )
                    )
                }
            }
        }
    }
}