package com.season.winter.common.extention.coroutine

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope

suspend fun LifecycleOwner.cbWhenStarted(
    block: suspend CoroutineScope.() -> Unit
) {
    repeatOnLifecycle(Lifecycle.State.STARTED) {
        block()
    }
}