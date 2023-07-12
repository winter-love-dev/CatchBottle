package com.season.winter.designsystem.border

import com.season.winter.designsystem.R

enum class BorderRadius {
    Xs,
    S,
    M,
    L,
    ;

    val value: Int get() = when(this) {
        Xs -> R.dimen.border_radius_xs
        S -> R.dimen.border_radius_s
        M -> R.dimen.border_radius_m
        L -> R.dimen.border_radius_l
    }
}