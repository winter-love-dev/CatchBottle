package com.season.winter.model.brand

import com.season.winter.model.alcoholInfo.AlcoholType
import com.season.winter.model.content.FeatureData

data class Brand(
//    val number: Int,
//    val nameKo: String,
//    val nameEn: String,
//    val countryCode: CountryCode, // 제조 국가 코드
    val brandCode: BrandCode,
    val features: List<FeatureData>, // 브랜드 소갯말
    val productType: List<AlcoholType>, // 생산 품목
)