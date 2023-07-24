package com.season.winter.liquor.brand

import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.content.FeatureData

data class Brand(
    val brandCode: BrandCode,
    val features: List<FeatureData>, // 브랜드 소갯말
    val productType: List<LiquorType>, // 생산 품목
)