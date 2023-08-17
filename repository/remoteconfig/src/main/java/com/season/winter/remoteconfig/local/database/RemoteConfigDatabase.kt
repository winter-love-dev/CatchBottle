package com.season.winter.remoteconfig.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.season.winter.remoteconfig.constants.DatabaseName_RemoteConfig
import com.season.winter.remoteconfig.local.dao.RemoteConfigFetcherDao
import com.season.winter.remoteconfig.local.dao.RemoteConfigDao
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

    abstract fun remoteConfigDao(): RemoteConfigDao
    abstract fun remoteConfigFetcherDao(): RemoteConfigFetcherDao

    companion object {

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
//                .addTypeConverter(RemoteConfigConverters)
                .addCallback(
                object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        /** 향후 worker 적용을 위해 주석 지우지 않고 남겨두기 */
                        // 인터넷 연결중일 때만 실행하기
//                        val constraints = Constraints.Builder()
//                            .setRequiredNetworkType(NetworkType.CONNECTED)
//                            .build()

//                        val request =
//                            PeriodicWorkRequestBuilder<RemoteConfigFetcherWorker>(
//                                repeatInterval = 1,
////                                TimeUnit.HOURS, // 1시간 마다 1회 실행
//                                TimeUnit.MINUTES, // 1시간 마다 1회 실행
//                                flexTimeInterval = 15,
//                                TimeUnit.MINUTES // 1시간 마다 실행되며 15분간 지속되게 설정
//                            )
//                            .setConstraints(constraints)
//                            .build()

//                        val request = OneTimeWorkRequestBuilder<RemoteConfigFetcherWorker>()
//                            .setConstraints(constraints)
//                            .build()
//
//                        WorkManager
//                            .getInstance(context)
//                            .enqueue(request)
                    }
                }
            )
            .build()
        }
    }
}