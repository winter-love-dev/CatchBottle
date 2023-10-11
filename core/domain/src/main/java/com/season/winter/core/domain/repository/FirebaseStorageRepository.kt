package com.season.winter.core.domain.repository

interface FirebaseStorageRepository {
    suspend fun getImageUrlFromFileName(fileName: String): String?
}