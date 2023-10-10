package com.season.winter.common.extention.view

import android.os.SystemClock.elapsedRealtime
import android.view.View

abstract class DoubleClickListener(
    private val duration: Long = 200L
) : View.OnClickListener {

    private var timestampLastClick = 0L

    override fun onClick(v: View) {
        if ((elapsedRealtime() - timestampLastClick) < duration)
            onDoubleClick(v)
        timestampLastClick = elapsedRealtime()
    }

    abstract fun onDoubleClick(v: View)
}

inline fun View.setOnDoubleClickListener(
    duration: Long = 200L,
    crossinline onDoubleClick: (View) -> Unit
) {
    setOnClickListener(object : DoubleClickListener(duration) {
        override fun onDoubleClick(v: View) {
            onDoubleClick(v)
        }
    })
}
