package com.season.winter.core.domain.usecase

import android.util.Log
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.core.domain.database.RemoteConfigDao
import com.season.winter.core.domain.service.RemoteConfigService
import com.season.winter.remoteconfig.RemoteConfigKey
import com.season.winter.storage.ImageFireStorageDao
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 네트워크로 받은 설정 값을 저장하는 Repository
 */
class RemoteConfigFetcherUseCase @Inject constructor(
    private val remoteConfig: RemoteConfigService,
    private val fetcherDao: RemoteConfigDao,
    private val imageFireStorage: ImageFireStorageDao,
) {

    // lifecycleScope, viewModelScope 을 따르면 saveValueFromKey() 를 실행할 수 없기 때문에,
    // 해당 UseCase를 싱글톤으로 두어 별도의 coroutine을 선언함.
    // 실시간 패치가 되어야 하는 remote config의 특성상
    // 코루틴의 종료 시점은 앱이 종료될 때 함께 되는 것으로 의도하여 별도의 종료 코드를 추가하지 않음.
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        remoteConfig.announceFetched = { keys ->
            saveValueFromKey(keys)
        }
    }

    operator fun invoke() {
        coroutineScope.launch {
            fetch()
        }
    }

    suspend fun fetch() {
        remoteConfig.fetch()
    }

    private fun saveValueFromKey(keys: List<String>) {
        coroutineScope.launch {
            when {
                keys.contains(RemoteConfigKey.KeyBanner) ->
                    saveBannerData(RemoteConfigKey.KeyBanner)
                keys.contains(RemoteConfigKey.KeySomeOther) -> {

                }
            }
        }
    }

    private suspend fun saveBannerData(key: String) {
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
                    val url = imageFireStorage.getImageUrlFromFileName(imageFileName)
                    banner.imageUrl = url
                }
        }
    }

    companion object {

        private const val TAG = "RemoteConfigFetchObserver"
    }
}