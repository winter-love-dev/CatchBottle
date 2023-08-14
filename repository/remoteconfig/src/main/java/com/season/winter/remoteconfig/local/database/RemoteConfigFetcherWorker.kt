package com.season.winter.remoteconfig.local.database

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.remoteconfig.di.RemoteConfigImpl
import com.season.winter.remoteconfig.di.RemoteConfigImpl.Companion.KeyAll
import com.season.winter.remoteconfig.di.RemoteConfigImpl.Companion.KeyBanner
import com.season.winter.storage.ImageFireStorageInstance
import com.season.winter.ui.model.fragment.home.BannerData
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class RemoteConfigFetcherWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val remoteConfig: RemoteConfigImpl
): CoroutineWorker(context, workerParams)  {

    override suspend fun doWork(): Result {

        return withContext(Dispatchers.IO) {

            try {

                val fetchSuccess = remoteConfig.fetch()
                if(fetchSuccess.not())
                    return@withContext Result.failure()

                val bannerJsonString = remoteConfig.getString(KeyBanner)

                val bannerDataList = bannerJsonString
                    .decodeFromJsonStringSafety<List<BannerData>>()
                    ?.apply { this.loadBannerUrlFromFileName() }
                    ?: return@withContext Result.failure()

                Log.e(TAG, "doWork: bannerDataList: $bannerDataList", )

                val database = RemoteConfigDatabase.getInstance(applicationContext)
                database.remoteConfigDao().updateBannerAll(bannerDataList)

                remoteConfig.announceFetched(KeyAll)

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