package com.season.winter.liquor.liquorInfo.filter

import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.brand.CountryCode
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.LiquorStatus
import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.liquorInfo.WhiskyType

class LiquorFilter(list: List<LiquorInfo>) {

    private var liquorList: List<LiquorInfo> = list

    fun resetLiquorList(liquorList: List<LiquorInfo>) {
        this.liquorList = liquorList
    }

    fun search(
        liquorType: LiquorType? = null,
        liquorStatus: List<LiquorStatus>? = null,
        whiskyType: List<WhiskyType>? = null,
        brand: BrandInfo? = null,
        countryCode: CountryCode? = null,
    ): List<LiquorInfo> {
        return mutableListOf<LiquorInfo>().apply {
            liquorType?.run {
                val result = searchLiquorType(this)
                addAll(result)
            }
            liquorStatus?.run {
                val result = searchLiquorStatus(this)
                addAll(result)
            }
            whiskyType?.run {
                val result = searchWhiskyType(this)
                addAll(result)
            }
            brand?.run {
                val result = searchBrand(this)
                addAll(result)
            }
            countryCode?.run {
                val result = searchCountry(this)
                addAll(result)
            }
            distinctBy { it.identify } // 중복 데이터 제거
        }.toList()
    }

    fun searchAll(): List<LiquorInfo> {
        return liquorList
    }

    fun searchLiquorType(liquorType: LiquorType): List<LiquorInfo> {
        return liquorList.filter {
            it.liquorType == liquorType
        }
    }

    fun searchLiquorStatus(liquorStatus: List<LiquorStatus>): List<LiquorInfo> {
        return mutableListOf<LiquorInfo>().apply {
            liquorStatus.forEach { status ->
                val searchResult = liquorList.filter {
                    it.liquorStatus?.contains(status) == true
                }
                addAll(searchResult)
            }
            distinctBy { it.identify } // 중복 데이터 제거
        }.toList()
    }

    fun searchWhiskyType(whiskyType: List<WhiskyType>): List<LiquorInfo> {
        return mutableListOf<LiquorInfo>().apply {
            whiskyType.forEach { type ->
                val searchResult = liquorList.filter {
                    it.whiskyType?.contains(type) == true
                }
                addAll(searchResult)
            }
            distinctBy { it.identify } // 중복 데이터 제거
        }.toList()
    }

    fun searchBrand(brand: BrandInfo): List<LiquorInfo> {
        return liquorList.filter {
            it.brandCode == brand
        }
    }

    fun searchCountry(countryCode: CountryCode): List<LiquorInfo> {
        return liquorList.filter {
            it.brandCode.countryCode == countryCode
        }
    }
}