package com.season.winter.storage.impl

interface FirebaseStorageService {
    suspend fun getImageUrlFromFileName(fileName: String): String?
}