package com.season.winter.feature.main.navigation

import androidx.compose.ui.graphics.Color
import com.season.winter.designsystem.color.base.Palette
import com.season.winter.designsystem.graphic.CBGraphic
import com.season.winter.designsystem.iconography.CBIconography


sealed class NavGraph(
    val route: String,
    val icon: Int,
    val focusedColor: Color = Palette.BrandFirst.composeColor,
    val outFocusColor: Color = Palette.Gray4.composeColor
) {
    object Home : NavGraph(HomeScreen, CBGraphic.LogoIcon.res)
    object Map : NavGraph(MapScreen, CBIconography.Project.M)
    object WishList : NavGraph(WishListScreen, CBIconography.LikeFilled.M)
    object More : NavGraph(MoreScreen, CBIconography.More.M)

    companion object {

        const val HomeScreen = "home"
        const val MapScreen = "map"
        const val WishListScreen = "wish list"
        const val MoreScreen = "more"

        val items = listOf(
            Home,
            Map,
            WishList,
            More,
        )
    }
}