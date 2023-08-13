package com.season.winter.remoteconfig.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.season.winter.remoteconfig.constants.DatabaseName_RemoteConfig
import com.season.winter.remoteconfig.local.dao.RemoteConfigLocalDao
import com.season.winter.ui.model.fragment.home.BannerData

@Database(
    entities = [
        BannerData::class,
        // SomeOtherDataClass::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RemoteConfigConverters::class)
abstract class RemoteConfigDatabase: RoomDatabase() {

    abstract fun remoteConfigDao(): RemoteConfigLocalDao

    companion object {

        @Volatile private var instance: RemoteConfigDatabase? = null

        fun getInstance(
            context: Context,
        ): RemoteConfigDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): RemoteConfigDatabase {
            return Room.databaseBuilder(
                context,
                RemoteConfigDatabase::class.java,
                DatabaseName_RemoteConfig
            ).addCallback(
                object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        val request =
                            OneTimeWorkRequestBuilder<RemoteConfigFetcherWorker>()
                                //.setInputData(workDataOf(RemoteConfigFetcherWorker.TAG to remoteConfigManager))
                                .build()

                        WorkManager
                            .getInstance(context)
                            .enqueue(request)
                    }
                }
            )
            .build()
        }
    }
}