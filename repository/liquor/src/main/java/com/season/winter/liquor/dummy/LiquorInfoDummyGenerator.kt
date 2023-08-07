package com.season.winter.liquor.dummy

import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.dummy.dataSet.liquorInfo.americanLiquorInfoList
import com.season.winter.liquor.dummy.dataSet.liquorInfo.koreaLiquorInfoList
import com.season.winter.liquor.dummy.dataSet.liquorInfo.scotchLiquorInfoList
import com.season.winter.storage.ImageFireStorageInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LiquorInfoDummyGenerator {

    val dummyLiquorListAll = getLiquorListAll().apply {
        loadThumbnailUrlFromFileName()
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

    private fun loadThumbnailUrlFromFileName() {
        val context = Dispatchers.IO + SupervisorJob()
        CoroutineScope(context).launch {
            dummyLiquorListAll.run {
                forEach { liquorInfo ->
                    liquorInfo.thumbnailFileName?.let { thumbnailFileName ->
                        val url = ImageFireStorageInstance.getImageUrlFromFileName(thumbnailFileName)
                        liquorInfo.thumbnailUrl = url ?: ""
                    }
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
