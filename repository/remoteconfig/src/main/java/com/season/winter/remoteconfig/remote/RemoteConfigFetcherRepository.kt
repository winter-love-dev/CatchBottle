package com.season.winter.remoteconfig.remote

import android.util.Log
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.remoteconfig.di.RemoteConfigFetcherService
import com.season.winter.remoteconfig.di.RemoteConfigImpl
import com.season.winter.remoteconfig.local.dao.RemoteConfigFetcherDao
import com.season.winter.storage.ImageFireStorageInstance
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 네트워크로 받은 설정 값을 저장하는 Repository
 */
class RemoteConfigFetcherRepository @Inject constructor(
    private val remoteConfig: RemoteConfigImpl,
    private val fetcherDao: RemoteConfigFetcherDao,
): RemoteConfigFetcherService {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        coroutineScope.launch {
            remoteConfig.fetch()
        }
        coroutineScope.launch {
            remoteConfig.onFetchSuccessFlow.collect { keys ->
                keys.run {
                    when {
                        contains(RemoteConfigImpl.KeyBanner) -> saveBannerData(RemoteConfigImpl.KeyBanner)
                        contains(RemoteConfigImpl.KeySomeOther) -> {

                        }
                    }
                }
            }
        }
    }

    override suspend fun fetch() {
        remoteConfig.fetch()
    }

    override suspend fun saveBannerData(key: String) {
        val bannerJsonString = remoteConfig.getString(key)

        val bannerDataList = bannerJsonString
            ?.decodeFromJsonStringSafety<List<BannerData>>()
            ?.apply { loadBannerUrlFromFileName() } ?: return

        Log.e(TAG, "saveBannerData: bannerDataList: $bannerDataList", )
        fetcherDao.updateBannerAll(bannerDataList)
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

    companion object {

        private const val TAG = "RemoteConfigFetchObserver"
    }
}