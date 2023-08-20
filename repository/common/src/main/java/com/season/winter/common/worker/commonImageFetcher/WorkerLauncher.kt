package com.season.winter.common.worker.commonImageFetcher

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

fun launchCommonImagerFetcherWorker(context: Context) {

    // 인터넷 연결중일 때만 실행하기
    val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

    val request = OneTimeWorkRequestBuilder<CommonImageFetcherWorker>()
        .setConstraints(constraints)
        .build()

    WorkManager
        .getInstance(context)
        .enqueue(request)
}
