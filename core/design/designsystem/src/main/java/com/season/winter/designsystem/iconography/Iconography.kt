package com.season.winter.designsystem.iconography

import com.season.winter.core_design_resource.R

enum class Iconography {
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
    More,
    Refresh,
    Search,
    Setting,
    Status,
    ;

//    val s: Int // s 사이즈 아이콘
//    val l: Int // l 사이즈 아이콘
    val m: Int get() = when(this) {
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
        More           -> R.drawable.more
        Refresh        -> R.drawable.refresh
        Search         -> R.drawable.search
        Setting        -> R.drawable.search
        Status         -> R.drawable.status
    }
}