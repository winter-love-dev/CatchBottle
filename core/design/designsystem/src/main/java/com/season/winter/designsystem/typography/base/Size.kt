package com.season.winter.designsystem.typography.base

import com.season.winter.designsystem.R

enum class Size {
    Xs,
    S,
    M,
    L,
    Xl,
    Xxl,
    ;

    val value: Int get() = when(this) {
        Xs -> R.dimen.font_size_xs
        S -> R.dimen.font_size_s
        M -> R.dimen.font_size_m
        L -> R.dimen.font_size_l
        Xl -> R.dimen.font_size_xl
        Xxl -> R.dimen.font_size_xxl
    }
}
