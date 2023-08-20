package com.season.winter.common.util.device

import android.content.Context
import kotlin.math.roundToInt

@Volatile
private var customDisplaySize: CustomDisplaySize? = null

fun Context.getNewDisplaySize(): CustomDisplaySize {
    val displayMetrics = resources.displayMetrics
    val dpHeight = displayMetrics.heightPixels / displayMetrics.density
    val dpWidth = displayMetrics.widthPixels / displayMetrics.density
    return CustomDisplaySize(
        dpHeight,
        dpWidth,
        convertDPtoPX(dpHeight.toInt()),
        convertDPtoPX(dpWidth.toInt())
    )
}

fun Context.getDisplaySizeCached(): CustomDisplaySize {
    return customDisplaySize ?: synchronized(this) {
        customDisplaySize ?: getNewDisplaySize().also {
            customDisplaySize = it
        }
    }
}

fun Context.convertDPtoPX(dp: Int): Int {
    val density = resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}


data class CustomDisplaySize(
    val dpHeight: Float,
    val dpWidth: Float,
    val pixelHeight: Int,
    val pixelWidth: Int
)