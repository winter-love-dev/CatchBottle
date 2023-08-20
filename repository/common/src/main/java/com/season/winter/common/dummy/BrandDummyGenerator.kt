package com.season.winter.common.dummy

import com.season.winter.common.dataSet.brand.americanWhiskeyList
import com.season.winter.common.dataSet.brand.irishWhiskeyWhiskeyList
import com.season.winter.common.dataSet.brand.japaneseWhiskeyWhiskeyList
import com.season.winter.common.dataSet.brand.koreaWhiskeyWhiskeyList
import com.season.winter.common.dataSet.brand.scotchWhiskeyWhiskeyList
import com.season.winter.liquor.brand.Brand

class BrandDummyGenerator {
    fun getKoreaBrandList(): List<Brand> {
        return koreaWhiskeyWhiskeyList
    }

    fun getAmericanBrandList(): List<Brand> {
        return americanWhiskeyList
    }

    fun getIrishBrandList(): List<Brand> {
        return irishWhiskeyWhiskeyList
    }

    fun getJapaneseBrandList(): List<Brand> {
        return japaneseWhiskeyWhiskeyList
    }

    fun getScotchBrandList(): List<Brand> {
        return scotchWhiskeyWhiskeyList
    }

    fun getBrandListAll(): List<Brand> {
        return mutableListOf<Brand>().apply {
            addAll(koreaWhiskeyWhiskeyList)
            addAll(americanWhiskeyList)
            addAll(irishWhiskeyWhiskeyList)
            addAll(japaneseWhiskeyWhiskeyList)
            addAll(scotchWhiskeyWhiskeyList)
        }.toList()
    }

}
