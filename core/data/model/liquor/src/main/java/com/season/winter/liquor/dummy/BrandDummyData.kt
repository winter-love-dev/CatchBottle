package com.season.winter.liquor.dummy

import com.season.winter.liquor.brand.Brand
import com.season.winter.liquor.localDataSet.brand.americanWhiskeyList
import com.season.winter.liquor.localDataSet.brand.irishWhiskeyWhiskeyList
import com.season.winter.liquor.localDataSet.brand.japaneseWhiskeyWhiskeyList
import com.season.winter.liquor.localDataSet.brand.koreaWhiskeyWhiskeyList
import com.season.winter.liquor.localDataSet.brand.scotchWhiskeyWhiskeyList

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