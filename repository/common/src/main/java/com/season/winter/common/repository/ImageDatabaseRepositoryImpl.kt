package com.season.winter.common.repository

import com.season.winter.common.di.database.ImageDatabaseService
import com.season.winter.common.local.database.image.ImageDatabaseDao
import com.season.winter.storage.impl.FirebaseStorageImpl
import javax.inject.Inject

class ImageDatabaseRepositoryImpl @Inject constructor(
    private val imageFireStorage: FirebaseStorageImpl,
    private val imageDao: ImageDatabaseDao
): ImageDatabaseService {

    suspend fun getImageUrlCached(fileName: String): String? {
        val imageData = imageDao.getImage(fileName)
        val existImage = imageData?.url != null
        return if (existImage)
            imageData?.url
        else
            imageFireStorage.getImageUrlFromFileName(fileName)
    }
}