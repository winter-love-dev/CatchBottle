package com.season.winter.common.repository

import com.season.winter.common.di.database.ImageDatabaseService
import com.season.winter.common.local.database.ImageDatabaseDao
import javax.inject.Inject

class ImageDatabaseRepositoryImpl @Inject constructor(
    private val imageDao: ImageDatabaseDao
): ImageDatabaseService {

}