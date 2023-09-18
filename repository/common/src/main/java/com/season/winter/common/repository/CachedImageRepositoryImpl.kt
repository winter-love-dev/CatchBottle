package com.season.winter.common.repository

import com.season.winter.common.ImageNameUrlPairEntity
import com.season.winter.common.di.database.CachedImageRepository
import com.season.winter.common.local.database.image.ImageDatabaseRoomDao
import com.season.winter.storage.impl.FirebaseStorageImpl
import javax.inject.Inject

class CachedImageRepositoryImpl @Inject constructor(
    private val imageFireStorage: FirebaseStorageImpl,
    private val imageDao: ImageDatabaseRoomDao
): CachedImageRepository {

    override suspend fun getImageUrl(fileName: String): String? {
        val imageData = imageDao.getImage(fileName)
        val existImage = imageData?.url != null
        return if (existImage)
            imageData?.url
        else
            imageFireStorage.getImageUrlFromFileName(fileName).also {
                imageDao.insertImageData(
                    ImageNameUrlPairEntity(
                        fileName = fileName,
                        url = it
                    )
                )
            }
    }
}