package com.season.winter.core.data.repository

import com.season.winter.core.domain.database.ImageDatabaseRoomDao
import com.season.winter.core.domain.entity.ImageNameUrlPairEntity
import com.season.winter.core.domain.repository.CachedImageRepository
import com.season.winter.core.domain.repository.FirebaseStorageRepository
import javax.inject.Inject

class CachedImageRepositoryImpl @Inject constructor(
    private val imageFireStorage: FirebaseStorageRepository,
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