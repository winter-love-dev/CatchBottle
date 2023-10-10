package com.season.winter.core.data.repository

import com.season.winter.core.domain.repository.FirebaseStorageRepository
import com.season.winter.storage.ImageFireStorageDao
import javax.inject.Inject

class FirebaseStorageRepositoryImpl @Inject constructor(
    private val imageFireStorage: ImageFireStorageDao
): FirebaseStorageRepository {

    override suspend fun getImageUrlFromFileName(fileName: String): String? {
        return imageFireStorage.getImageUrlFromFileName(fileName)
    }

}