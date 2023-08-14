package com.season.winter.remoteconfig

import android.util.Log
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.remoteconfig.di.RemoteConfigImpl
import com.season.winter.remoteconfig.di.RemoteConfigImpl.Companion.KeyBanner
import com.season.winter.remoteconfig.di.RemoteConfigImpl.Companion.KeySomeOther
import com.season.winter.remoteconfig.di.RemoteConfigRepositoryService
import com.season.winter.remoteconfig.local.dao.RemoteConfigRoomDao
import com.season.winter.storage.ImageFireStorageInstance
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RemoteConfigRepositoryImpl @Inject constructor(
    private val remoteConfig: RemoteConfigImpl,
    private val localDao: RemoteConfigRoomDao,
): RemoteConfigRepositoryService {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        coroutineScope.let { coroutineScope ->
            coroutineScope.launch { fetch() }
            coroutineScope.launch {
                remoteConfig.onFetchSuccessFlow.collect { keys ->
                    keys.run {
                        when {
                            contains(KeyBanner) -> saveBannerData(KeyBanner)
                            contains(KeySomeOther) -> {

                            }
                        }
                    }
                }
            }
        }
    }

    fun getBanner(): Flow<List<BannerData>> {
        return localDao.getBannerAll()
    }

    override suspend fun saveBannerData(key: String) {
        val bannerJsonString = remoteConfig.getString(key)

        val bannerDataList = bannerJsonString
            .decodeFromJsonStringSafety<List<BannerData>>()
            ?.apply { loadBannerUrlFromFileName() } ?: return

        Log.e(TAG, "saveBannerData: bannerDataList: $bannerDataList", )
        localDao.updateBannerAll(bannerDataList)
    }

    private suspend fun List<BannerData>.loadBannerUrlFromFileName() {
        forEach { banner ->
            if (banner.imageUrl == null)
                banner.imageFileName.let { imageFileName ->
                    val url = ImageFireStorageInstance.getImageUrlFromFileName(imageFileName)
                    banner.imageUrl = url
                }
        }
    }


    override suspend fun fetch() {
        remoteConfig.fetch()
    }

    companion object {

        private const val TAG = "RemoteConfigRepositoryImpl"
    }
}