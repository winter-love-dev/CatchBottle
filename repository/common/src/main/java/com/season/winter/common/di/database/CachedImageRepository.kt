package com.season.winter.common.di.database

interface CachedImageRepository {
    suspend fun getImageUrl(fileName: String): String?
}