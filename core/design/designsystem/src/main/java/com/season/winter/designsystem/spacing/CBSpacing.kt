package com.season.winter.designsystem.spacing

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.season.winter.designsystem.R

enum class CBSpacing(
    val value: Int,
    val dp: Dp,
) {
    Zero(R.dimen.spacing_zero, 0.dp),
    Xxs(R.dimen.spacing_xxs, 4.dp),
    Xs(R.dimen.spacing_xs, 8.dp),
    S(R.dimen.spacing_s, 12.dp),
    M(R.dimen.spacing_m, 16.dp),
    L(R.dimen.spacing_l, 20.dp),
    Xl(R.dimen.spacing_xl, 32.dp),
    Xxl(R.dimen.spacing_xxl, 40.dp),
    Xxxl(R.dimen.spacing_xxxl, 60.dp),
    Xxxxl(R.dimen.spacing_xxxxl, 120.dp),
    ;
}