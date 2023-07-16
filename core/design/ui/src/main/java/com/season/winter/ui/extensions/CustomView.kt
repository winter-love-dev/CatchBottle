package com.season.winter.ui.extensions

import android.content.res.TypedArray

@Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
fun <T: Any> TypedArray.getAttr(attrRes: Int, defaultValue: T): T {
    var attr: Int? = null
    for(i in 0 until indexCount) getIndex(i).let { index ->
        if (index == attrRes)
            attr = index
    }

    if (attr == null)
        return defaultValue

    return when(defaultValue) {
        is Boolean -> getBoolean(attr!!, defaultValue)
        is String  -> getString(attr!!) ?: defaultValue
        is Int     -> getInt(attr!!, defaultValue)
        else       -> defaultValue
    } as T
}