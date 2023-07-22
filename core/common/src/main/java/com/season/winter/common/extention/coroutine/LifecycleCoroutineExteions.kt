package com.season.winter.common.extention.coroutine

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

suspend fun LifecycleOwner.cbWhenStarted(
    block: suspend CoroutineScope.() -> Unit
) {
    repeatOnLifecycle(Lifecycle.State.STARTED) {
        block()
    }
}

fun <T> LifecycleOwner.repeatOnLifecycle(
    flow: Flow<T>,
    callback: (item: T) -> Unit,
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                callback(it)
            }
        }
    }
}