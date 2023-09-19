package com.season.winter.common.dummy

import com.season.winter.liquor.liquorInfo.LiquorInfo

interface DummyLiquorInfoRepository {
    suspend fun getKoreaLiquorInfoList(): List<LiquorInfo>
    suspend fun getAmericanLiquorInfoList(): List<LiquorInfo>
    suspend fun getScotchLiquorInfoList(): List<LiquorInfo>
    suspend fun liquorListAll(): List<LiquorInfo>
}