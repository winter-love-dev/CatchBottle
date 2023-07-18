package com.season.winter.main_navigation_contents.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {

    var count = 0
    var onCountFlow = MutableStateFlow(0)

    fun countUp() {
        count+=1
        onCountFlow.value = count
    }

    fun printCount() {
        Log.e("TAG", "printCount: count: $count", )
    }

}