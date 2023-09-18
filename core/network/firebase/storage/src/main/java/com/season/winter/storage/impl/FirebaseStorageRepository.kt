package com.season.winter.storage.impl

interface FirebaseStorageRepository {
    suspend fun getImageUrlFromFileName(fileName: String): String?
}