package com.season.winter.storage.impl

import com.season.winter.storage.ImageFireStorage
import javax.inject.Inject

class FirebaseStorageImpl @Inject constructor(
    private val imageFireStorage: ImageFireStorage
): FirebaseStorageRepository {

    override suspend fun getImageUrlFromFileName(fileName: String): String? {
        return imageFireStorage.getImageUrlFromFileName(fileName)
    }

}