package com.season.winter.liquor.dummy

import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.dummy.dataSet.liquorInfo.americanLiquorInfoList
import com.season.winter.liquor.dummy.dataSet.liquorInfo.koreaLiquorInfoList
import com.season.winter.liquor.dummy.dataSet.liquorInfo.scotchLiquorInfoList
import com.season.winter.liquor.liquorInfo.filter.LiquorFilterOption
import com.season.winter.ui.model.fragment.home.HomeItemType

class LiquorInfoDummyGenerator {

    fun getKoreaLiquorInfoList(): List<LiquorInfo> {
        return koreaLiquorInfoList
    }

    fun getAmericanLiquorInfoList(): List<LiquorInfo> {
        return americanLiquorInfoList
    }

    fun getScotchLiquorInfoList(): List<LiquorInfo> {
        return scotchLiquorInfoList
    }

    fun getLiquorListAll(): List<LiquorInfo> {
        return mutableListOf<LiquorInfo>().apply {
            addAll(koreaLiquorInfoList)
            addAll(americanLiquorInfoList)
            addAll(scotchLiquorInfoList)
        }.toList()
    }

}
