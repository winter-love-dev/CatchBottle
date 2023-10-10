package com.season.winter.core.data.repository.dummy


import com.season.winter.core.data.repository.dummy.dataSet.brand.americanWhiskeyList
import com.season.winter.core.data.repository.dummy.dataSet.brand.irishWhiskeyWhiskeyList
import com.season.winter.core.data.repository.dummy.dataSet.brand.japaneseWhiskeyWhiskeyList
import com.season.winter.core.data.repository.dummy.dataSet.brand.koreaWhiskeyWhiskeyList
import com.season.winter.core.data.repository.dummy.dataSet.brand.scotchWhiskeyWhiskeyList
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
