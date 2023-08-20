package com.season.winter.common.repository

import com.season.winter.common.di.database.ImageDatabaseFetcherService
import com.season.winter.common.local.database.image.ImageDatabaseFetcherDao
import javax.inject.Inject

class ImageDatabaseRepositoryFetcherImpl @Inject constructor(
    private val fetcherDao: ImageDatabaseFetcherDao
): ImageDatabaseFetcherService {

    override suspend fun wakeDB() {
        fetcherDao.checkForSearchImageData("")
    }

}