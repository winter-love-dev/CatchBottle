package com.season.winter.common.extention.activity

import android.app.Activity
import android.content.Intent

fun <T: Activity> Activity.startActivitySimpleTransition(
    activity: Class<T>,
    noAnimation: Boolean = false,
) = Intent(this, activity) .run {
    if(noAnimation)
        addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
    startActivity(this)
}