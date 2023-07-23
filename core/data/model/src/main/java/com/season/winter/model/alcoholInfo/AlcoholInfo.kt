package com.season.winter.model.alcoholInfo

import com.season.winter.model.brand.BrandCode
import com.season.winter.model.content.FeatureData

data class AlcoholInfo(
    val nameKo: String,
    val nameEn: String,
    var like: Int, // 좋아요 수
    val brandCode: BrandCode,
    val productType: AlcoholType, // 주류 유형
    val whiskyType: WhiskyType? = null, // 위스키 유형
    val priceKrw: Int, // 판매금액, 원화
    val discountRate: Float, // 할인율 %, int only
    val operatorComment: List<FeatureData>, // 운영진 소갯말
    val features: List<FeatureData>, // 제품 공식 설명
    val capacityToMl: Float, // ml 단위 용량
    val alcoholByVolume: Float, // 도수 %
    val aromaCode: List<AlcoholExpressionCode>, // 향 (AlcoholExpressionCode 표 참조)
    val tasteCode: List<AlcoholExpressionCode>, // 맛 (AlcoholExpressionCode 표 참조)
    val finishCode: List<AlcoholExpressionCode>, // 여운 (AlcoholExpressionCode 표 참조)
)