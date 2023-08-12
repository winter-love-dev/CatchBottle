package com.season.winter.room.remoteConfig

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.season.winter.room.constants.DatabaseName_RemoteConfig

abstract class RemoteConfigDatabase: RoomDatabase() {



    companion object {

        // For Singleton instantiation
        @Volatile private var instance: RemoteConfigDatabase? = null

        fun getInstance(context: Context): RemoteConfigDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): RemoteConfigDatabase {
            return Room.databaseBuilder(
                context,
                RemoteConfigDatabase::class.java,
                DatabaseName_RemoteConfig
            )
//                .addCallback(
//                    object : RoomDatabase.Callback() {
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
//                                .setInputData(workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME))
//                                .build()
//                            WorkManager.getInstance(context).enqueue(request)
//                        }
//                    }
//                )
                .build()
        }
    }
}