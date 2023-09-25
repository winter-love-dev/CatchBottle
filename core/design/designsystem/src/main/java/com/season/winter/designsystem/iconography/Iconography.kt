package com.season.winter.designsystem.iconography

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.season.winter.core_design_resource.R

enum class CBIconography {
    Add,
    ArrowUp,
    ArrowDown,
    ArrowLeft,
    ArrowRight,
    ArrowNaviLeft,
    ArrowNaviRight,
    Check,
    Close,
    Copy,
    Delete,
    Docs,
    FingerPrint,
    LikeFilled,
    LikeOutLined,
    List,
    Menu,
    Minus,
    Plus,
    Project,
    More,
    Refresh,
    Search,
    Setting,
    Status,
    ;

//    val s: Int // s 사이즈 아이콘
//    val l: Int // l 사이즈 아이콘
    val m: Painter @Composable get() = when(this) {
        Add            -> painterResource(R.drawable.add)
        ArrowUp        -> painterResource(R.drawable.arrow_up)
        ArrowDown      -> painterResource(R.drawable.arrow_down)
        ArrowLeft      -> painterResource(R.drawable.arrow_left)
        ArrowRight     -> painterResource(R.drawable.arrow_right)
        ArrowNaviLeft  -> painterResource(R.drawable.arrow_navi_left)
        ArrowNaviRight -> painterResource(R.drawable.arrow_navi_right)
        Check          -> painterResource(R.drawable.check)
        Close          -> painterResource(R.drawable.close)
        Copy           -> painterResource(R.drawable.copy)
        Delete         -> painterResource(R.drawable.delete)
        Docs           -> painterResource(R.drawable.docs)
        FingerPrint    -> painterResource(R.drawable.finger_print)
        LikeFilled     -> painterResource(R.drawable.like_filled)
        LikeOutLined   -> painterResource(R.drawable.like_outlined)
        List           -> painterResource(R.drawable.list)
        Menu           -> painterResource(R.drawable.menu)
        Minus          -> painterResource(R.drawable.minus)
        Plus           -> painterResource(R.drawable.plus)
        Project        -> painterResource(R.drawable.project)
        More           -> painterResource(R.drawable.more)
        Refresh        -> painterResource(R.drawable.refresh)
        Search         -> painterResource(R.drawable.search)
        Setting        -> painterResource(R.drawable.search)
        Status         -> painterResource(R.drawable.status)
    }

    val M: Int get() = when(this) {
        Add            -> R.drawable.add
        ArrowUp        -> R.drawable.arrow_up
        ArrowDown      -> R.drawable.arrow_down
        ArrowLeft      -> R.drawable.arrow_left
        ArrowRight     -> R.drawable.arrow_right
        ArrowNaviLeft  -> R.drawable.arrow_navi_left
        ArrowNaviRight -> R.drawable.arrow_navi_right
        Check          -> R.drawable.check
        Close          -> R.drawable.close
        Copy           -> R.drawable.copy
        Delete         -> R.drawable.delete
        Docs           -> R.drawable.docs
        FingerPrint    -> R.drawable.finger_print
        LikeFilled     -> R.drawable.like_filled
        LikeOutLined   -> R.drawable.like_outlined
        List           -> R.drawable.list
        Menu           -> R.drawable.menu
        Minus          -> R.drawable.minus
        Plus           -> R.drawable.plus
        Project        -> R.drawable.project
        More           -> R.drawable.more
        Refresh        -> R.drawable.refresh
        Search         -> R.drawable.search
        Setting        -> R.drawable.search
        Status         -> R.drawable.status
    }
}