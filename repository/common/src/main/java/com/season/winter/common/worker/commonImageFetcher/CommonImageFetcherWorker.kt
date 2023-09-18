package com.season.winter.common.worker.commonImageFetcher

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.season.winter.common.ImageNameUrlPairEntity
import com.season.winter.common.dataSet.liquorInfo.americanLiquorInfoList
import com.season.winter.common.dataSet.liquorInfo.koreaLiquorInfoList
import com.season.winter.common.dataSet.liquorInfo.scotchLiquorInfoList
import com.season.winter.common.local.database.image.ImageRoomDatabase
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.storage.ImageFireStorage
import java.lang.Exception


class CommonImageFetcherWorker(
    context: Context,
    workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val database = ImageRoomDatabase.getInstance(applicationContext)
//            val dao = database.imageDataDao()
//            val fetcherDao = database.imageDataFetcherDao()
            fetchLiquorThumb(database)
            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "Error Fetching Common Image: ${e.message}")
            Result.failure()
        }
    }

    private fun getLiquorListAll(): List<LiquorInfo> {
        return mutableListOf<LiquorInfo>().apply {
            addAll(koreaLiquorInfoList)
            addAll(americanLiquorInfoList)
            addAll(scotchLiquorInfoList)
        }.toList()
    }

    private suspend fun fetchLiquorThumb(imageDatabase: ImageRoomDatabase) {

        val imageFireStorage = ImageFireStorage()

        val fetcherDao = imageDatabase.imageDataDao()

        val liquorDummyList = getLiquorListAll()

        val imageDataList = mutableListOf<ImageNameUrlPairEntity>()

        liquorDummyList.forEach { liquorInfo ->
            liquorInfo.thumbnailFileName?.let { thumbnailFileName ->
                val imageData = fetcherDao.checkForSearchImageData(thumbnailFileName)
                val existImage = imageData?.url != null
                if (existImage.not()) {
                    val url = imageFireStorage.getImageUrlFromFileName(thumbnailFileName)
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