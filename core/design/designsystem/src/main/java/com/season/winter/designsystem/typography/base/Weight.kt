package com.season.winter.designsystem.typography.base

import com.season.winter.designsystem.R

enum class Weight {
    _700,
    _600,
    _500,
    ;

    val value: Int get() = when(this) {
        _700 -> R.dimen.font_weight_700
        _600 -> R.dimen.font_weight_600
        _500 -> R.dimen.font_weight_500
    }
}