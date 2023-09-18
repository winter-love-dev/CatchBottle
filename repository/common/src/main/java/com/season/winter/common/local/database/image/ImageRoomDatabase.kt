package com.season.winter.common.local.database.image

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.season.winter.common.ImageNameUrlPairEntity
import com.season.winter.common.constants.DatabaseName_ImageDatabase
import com.season.winter.common.converter.ImageDatabaseConverter
import com.season.winter.common.worker.commonImageFetcher.launchCommonImagerFetcherWorker

@Database(
    entities = [
        ImageNameUrlPairEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(ImageDatabaseConverter::class)
abstract class ImageRoomDatabase: RoomDatabase() {

    abstract fun imageDataDao(): ImageDatabaseRoomDao

    companion object {

        @Volatile
        private var instance: ImageRoomDatabase? = null

        fun getInstance(context: Context): ImageRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ImageRoomDatabase {
            return Room.databaseBuilder(
                context,
                ImageRoomDatabase::class.java,
                DatabaseName_ImageDatabase
            )
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            launchCommonImagerFetcherWorker(context)
                        }
                    }
                ).build()
        }
    }
}