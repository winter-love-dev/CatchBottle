package com.season.winter.liquor.liquorInfo.filter

import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.brand.CountryCode
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.LiquorStatus
import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.liquorInfo.WhiskyType

enum class LiquorFilterOption{
    All,
    ByMultiExpression,
    ByLiquorType,
    ByLiquorStatus,
    ByWhiskyType,
    ByBrand,
    ByCountry,
//    ByWishCount,
//    ByRating,
    ;

    var liquorType: LiquorType? = null
        private set

    var liquorStatus: List<LiquorStatus>? = null
        private set

    var whiskyType: List<WhiskyType>? = null
        private set

    var brand: BrandInfo? = null
        private set

    var countryCode: CountryCode? = null
        private set

    fun search(): List<LiquorInfo> {
        if (isInitFilter.not()) return emptyList()

        return when(this) {
            All -> filter.searchAll()
            ByMultiExpression -> filter.search(
                liquorType = liquorType,
                liquorStatus = liquorStatus,
                whiskyType = whiskyType,
                brand = brand,
            )
            ByLiquorType -> liquorType?.let {
                filter.searchLiquorType(it)
            }
            ByLiquorStatus -> liquorStatus?.let {
                filter.searchLiquorStatus(it)
            }
            ByWhiskyType -> whiskyType?.run {
                filter.searchWhiskyType(whiskyType = this)
            }
            ByBrand -> brand?.run {
                filter.searchBrand(brand = this)
            }
            ByCountry -> countryCode?.run {
                filter.searchCountry(countryCode = this)
            }
        } ?: emptyList()
    }

    fun generateFilterOption(
        liquorType: LiquorType? = null,
        liquorStatus: List<LiquorStatus>? = null,
        whiskyType: List<WhiskyType>? = null,
        brand: BrandInfo? = null,
        countryCode: CountryCode? = null,
    ): LiquorFilterOption {
        return when(this) {
            All -> All
            ByMultiExpression -> ByMultiExpression.apply {
                this.liquorType = liquorType
                this.liquorStatus = liquorStatus
                this.whiskyType = whiskyType
                this.brand = brand
            }
            ByLiquorType -> ByLiquorType.apply {
                this.liquorType = liquorType
            }
            ByLiquorStatus -> ByLiquorStatus.apply {
                this.liquorStatus = liquorStatus
            }
            ByWhiskyType -> ByWhiskyType.apply {
                this.whiskyType = whiskyType
            }
            ByBrand -> ByBrand.apply {
                this.brand = brand
            }
            ByCountry -> ByCountry.apply {
                this.countryCode = countryCode
            }
        }
    }

    companion object {

        val isInitFilter: Boolean
            get() = Companion::filter.isInitialized

        private lateinit var liquorList: List<LiquorInfo>

        @Volatile
        private lateinit var filter: LiquorFilter

        fun initFilter(liquorList: List<LiquorInfo>) {
            Companion.liquorList = liquorList

            if (Companion::filter.isInitialized.not())
                filter = LiquorFilter(liquorList)
            else
                filter.resetLiquorList(liquorList)
        }
    }
}