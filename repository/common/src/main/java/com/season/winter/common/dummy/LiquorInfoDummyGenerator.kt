package com.season.winter.common.dummy

import com.season.winter.common.dataSet.liquorInfo.americanLiquorInfoList
import com.season.winter.common.dataSet.liquorInfo.koreaLiquorInfoList
import com.season.winter.common.dataSet.liquorInfo.scotchLiquorInfoList
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.storage.ImageFireStorageInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LiquorInfoDummyGenerator @Inject constructor() {

    private var isInitThumb = false

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val _liquorInfoListFlow = MutableSharedFlow<List<LiquorInfo>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val liquorInfoListFlow: SharedFlow<List<LiquorInfo>>
        get() = _liquorInfoListFlow.asSharedFlow()

    private val dummyLiquorListAll = getLiquorListAll().apply {
        emitLiquorListAll()
    }

    fun getAllLiquorDummy(): List<LiquorInfo> {
        return dummyLiquorListAll
    }

    fun emitLiquorListAll() {
        coroutineScope.launch {
            if (isInitThumb.not()) {
                loadThumbnailUrlFromFileName()
                isInitThumb = true
            }

            _liquorInfoListFlow.tryEmit(dummyLiquorListAll)
        }
    }

    fun getKoreaLiquorInfoList(): List<LiquorInfo> {
        return koreaLiquorInfoList
    }

    fun getAmericanLiquorInfoList(): List<LiquorInfo> {
        return americanLiquorInfoList
    }

    fun getScotchLiquorInfoList(): List<LiquorInfo> {
        return scotchLiquorInfoList
    }

    suspend fun loadThumbnailUrlFromFileName() {
        dummyLiquorListAll.run {
            forEach { liquorInfo ->
                liquorInfo.thumbnailFileName?.let { thumbnailFileName ->
                    val url = ImageFireStorageInstance.getImageUrlFromFileName(thumbnailFileName)
                    liquorInfo.thumbnailUrl = url ?: ""
                }
            }
        }
    }

    private fun getLiquorListAll(): List<LiquorInfo> {
        return mutableListOf<LiquorInfo>().apply {
            addAll(koreaLiquorInfoList)
            addAll(americanLiquorInfoList)
            addAll(scotchLiquorInfoList)
        }.toList()
    }

}
