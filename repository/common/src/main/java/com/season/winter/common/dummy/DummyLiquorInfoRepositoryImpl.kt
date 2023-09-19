package com.season.winter.common.dummy

import com.season.winter.common.dataSet.liquorInfo.americanLiquorInfoList
import com.season.winter.common.dataSet.liquorInfo.koreaLiquorInfoList
import com.season.winter.common.dataSet.liquorInfo.scotchLiquorInfoList
import com.season.winter.common.di.database.CachedImageRepository
import com.season.winter.liquor.liquorInfo.LiquorInfo
import javax.inject.Inject

class DummyLiquorInfoRepositoryImpl @Inject constructor(
    private val imageDatabaseRepository: CachedImageRepository
): DummyLiquorInfoRepository {

    private val dummyLiquorListKorea = mutableListOf<LiquorInfo>()
    private val dummyLiquorListScotch = mutableListOf<LiquorInfo>()
    private val dummyLiquorListAmerican = mutableListOf<LiquorInfo>()
    private val dummyLiquorListAll = mutableListOf<LiquorInfo>()

    override suspend fun getKoreaLiquorInfoList(): List<LiquorInfo> {
        dummyLiquorListKorea.let { dummyLiquorListKorea ->
            if (dummyLiquorListKorea.isNotEmpty())
                return dummyLiquorListKorea

            dummyLiquorListKorea.addAll(koreaLiquorInfoList)
            dummyLiquorListKorea.apply {
                loadThumb()
            }
            return dummyLiquorListKorea
        }
    }

    override suspend fun getAmericanLiquorInfoList(): List<LiquorInfo> {
        dummyLiquorListAmerican.let { list ->
            if (list.isNotEmpty())
                return list

            list.addAll(americanLiquorInfoList)
            list.apply {
                loadThumb()
            }
            return list
        }
    }

    override suspend fun getScotchLiquorInfoList(): List<LiquorInfo> {
        dummyLiquorListScotch.let { list ->
            if (list.isNotEmpty())
                return list

            list.addAll(scotchLiquorInfoList)
            list.apply {
                loadThumb()
            }
            return list
        }
    }

    override  suspend fun liquorListAll(): List<LiquorInfo> {
        dummyLiquorListAll.let { list ->
            if (list.isNotEmpty()) {
                return list
            }

            return mutableListOf<LiquorInfo>().apply {
                addAll(koreaLiquorInfoList)
                addAll(americanLiquorInfoList)
                addAll(scotchLiquorInfoList)

                loadThumb()

                dummyLiquorListAll.addAll(this)
            }.toList()
        }
    }

    private suspend fun List<LiquorInfo>.loadThumb() {
        forEach { liquorInfo ->
            liquorInfo.thumbnailFileName?.let { thumbnailFileName ->
                val url = imageDatabaseRepository.getImageUrl(thumbnailFileName)
                liquorInfo.thumbnailUrl = url ?: ""
            }
        }
    }
}
