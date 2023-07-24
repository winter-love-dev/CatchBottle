package com.season.winter.model.dummy

import com.season.winter.model.alcoholInfo.AlcoholInfo
import com.season.winter.model.dummy.localDataSet.alcoholInfo.koreaAlcoholInfoList
import com.season.winter.model.dummy.localDataSet.alcoholInfo.americanAlcoholInfoList
import com.season.winter.model.dummy.localDataSet.alcoholInfo.scotchAlcoholInfoList

class AlcoholInfoDummyGenerator {

    fun getKoreaAlcoholInfoList(): List<AlcoholInfo> {
        return koreaAlcoholInfoList
    }

    fun getAmericanAlcoholInfoList(): List<AlcoholInfo> {
        return americanAlcoholInfoList
    }

    fun getScotchAlcoholInfoList(): List<AlcoholInfo> {
        return scotchAlcoholInfoList
    }

    fun getAlcoholListAll(): List<AlcoholInfo> {
        return mutableListOf<AlcoholInfo>().apply {
            addAll(koreaAlcoholInfoList)
            addAll(americanAlcoholInfoList)
            addAll(scotchAlcoholInfoList)
        }.toList()
    }

}
