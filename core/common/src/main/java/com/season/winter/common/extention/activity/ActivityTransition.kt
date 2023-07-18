package com.season.winter.common.extention.activity

import android.app.Activity
import android.content.Intent

enum class CBActivityTransition {
    LEFT,
    RIGHT,
    UP,
    DOWN,
}

fun <T: Activity> Activity.cbStartActivity(
    activity: Class<T>,
    finishThisActivity: Boolean = true,
    transition: CBActivityTransition? = null
) = Intent(this, activity).run {

    if(transition == null)
        addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

    startActivity(this)
    if (finishThisActivity)
        finish()
}