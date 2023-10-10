package com.season.winter.core.domain.repository

interface CachedImageRepository {
    suspend fun getImageUrl(fileName: String): String?
}