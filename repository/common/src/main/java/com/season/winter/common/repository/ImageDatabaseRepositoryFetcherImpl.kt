package com.season.winter.common.repository

import com.season.winter.common.di.database.ImageDatabaseFetcherService
import com.season.winter.common.local.database.image.ImageDatabaseDao
import javax.inject.Inject

class ImageDatabaseRepositoryFetcherImpl @Inject constructor(
    private val fetcherDao: ImageDatabaseDao
): ImageDatabaseFetcherService {

    override suspend fun wakeDB() {
        fetcherDao.checkForSearchImageData("")
    }

}