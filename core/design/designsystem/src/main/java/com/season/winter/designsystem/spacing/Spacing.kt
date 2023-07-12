package com.season.winter.designsystem.spacing

import com.season.winter.designsystem.R

enum class Spacing {
    Xxs,
    Xs,
    S,
    M,
    L,
    Xl,
    Xxl,
    Xxxl,
    Xxxxl,
    ;

    val value: Int get() = when(this) {
        Xxs -> R.dimen.spacing_xxs
        Xs -> R.dimen.spacing_xs
        S -> R.dimen.spacing_s
        M -> R.dimen.spacing_m
        L -> R.dimen.spacing_l
        Xl -> R.dimen.spacing_xl
        Xxl -> R.dimen.spacing_xxl
        Xxxl -> R.dimen.spacing_xxxl
        Xxxxl -> R.dimen.spacing_xxxxl
    }
}