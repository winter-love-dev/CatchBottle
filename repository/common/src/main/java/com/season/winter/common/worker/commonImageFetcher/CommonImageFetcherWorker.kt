package com.season.winter.common.worker.commonImageFetcher

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.season.winter.common.ImageNameUrlPairEntity
import com.season.winter.common.local.database.ImageDatabase
import com.season.winter.liquor.dummy.dummy.LiquorInfoDummyGenerator
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.storage.ImageFireStorageInstance
import java.lang.Exception


class CommonImageFetcherWorker(
    context: Context,
    workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val database = ImageDatabase.getInstance(applicationContext)
//            val dao = database.imageDataDao()
//            val fetcherDao = database.imageDataFetcherDao()
            fetchLiquorThumb(database)
            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "Error Fetching Common Image: ${e.message}")
            Result.failure()
        }
    }

    private suspend fun fetchLiquorThumb(imageDatabase: ImageDatabase) {

        val fetcherDao = imageDatabase.imageDataFetcherDao()

        val liquorDummyList = LiquorInfoDummyGenerator().getAllLiquorDummy()

        val imageDataList = mutableListOf<ImageNameUrlPairEntity>()

        liquorDummyList.forEach { liquorInfo ->
            liquorInfo.thumbnailFileName?.let { thumbnailFileName ->
                val imageData = fetcherDao.checkForSearchImageData(thumbnailFileName)
                val existImage = imageData?.url != null
                if (existImage.not()) {
                    val url = ImageFireStorageInstance.getImageUrlFromFileName(thumbnailFileName)
                    imageDataList.add(
                        ImageNameUrlPairEntity(
                            fileName = thumbnailFileName,
                            url = url
                        )
                    )
                }
            }
        }
        fetcherDao.insertImageDataList(imageDataList.toList())
    }

    companion object {
        const val TAG = "CommonImageFetcherWorker"
    }
}