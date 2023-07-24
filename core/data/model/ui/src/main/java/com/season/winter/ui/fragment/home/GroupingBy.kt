package com.season.winter.ui.fragment.home

import com.season.winter.liquor.brand.BrandCode
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.LiquorStatus
import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.liquorInfo.WhiskyType

enum class GroupingBy(
    var liquorType: LiquorType? = null, // 주류 유형 기준
    var liquorStatus: LiquorStatus? = null, // 주류 상태 기준
    var brand: BrandCode? = null, // 브랜드 기준
    var whiskyType: WhiskyType? = null, // 위스키 유형 기준
) {
    ByLiquorType(),
    ByLiquorStatus(),
    ByBrand(),
    ByWhiskyType(),
    ;

    companion object {
        fun search(set: List<GroupingBy>): List<LiquorInfo> {
            return emptyList()
        }
    }
}