package com.season.winter.common.di.database

interface ImageDatabaseFetcherService {
    suspend fun wakeDB()
}