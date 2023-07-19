package com.season.winter.common.extention.view

import android.content.res.ColorStateList
import android.view.View

fun View.setBackgroundTintColor(colorRes: Int) {
    backgroundTintList = ColorStateList.valueOf(colorRes)
}
