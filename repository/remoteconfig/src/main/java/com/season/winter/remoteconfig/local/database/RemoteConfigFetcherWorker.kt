package com.season.winter.remoteconfig.local.database

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.remoteconfig.RemoteConfigManager
import com.season.winter.storage.ImageFireStorageInstance
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteConfigFetcherWorker @Inject constructor(
    context: Context,
    workerParams: WorkerParameters,
    private val remoteConfigDao: RemoteConfigManager
): CoroutineWorker(context, workerParams)  {

    override suspend fun doWork(): Result {

        return withContext(Dispatchers.IO) {
            try {
                val bannerJsonString = remoteConfigDao
                    .fetchBannerConfig()

                val bannerDataList = bannerJsonString
                    ?.decodeFromJsonStringSafety<List<BannerData>>()
                    ?.apply {
                        this.loadBannerUrlFromFileName()
                    } ?: return@withContext Result.failure()

                Log.e(TAG, "doWork: bannerDataList: $bannerDataList", )

                val database = RemoteConfigDatabase.getInstance(applicationContext)
                database.remoteConfigDao().insertBannerAll(bannerDataList)

                Result.success()
            } catch (ex: Exception) {
                Log.e(TAG, "doWork: error: ${ex.message}")
                Result.failure()
            }
        }
    }

    private suspend fun List<BannerData>.loadBannerUrlFromFileName() {
        forEach { liquorInfo ->
            liquorInfo.imageUrl?.let { thumbnailFileName ->
                val url = ImageFireStorageInstance.getImageUrlFromFileName(thumbnailFileName)
                liquorInfo.imageUrl = url
            }
        }
    }

    companion object {

        const val TAG = "RemoteConfigFetcherWorker"
    }
}