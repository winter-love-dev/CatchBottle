package com.season.winter.liquor.liquorInfo

import com.season.winter.liquor.brand.BrandCode
import com.season.winter.liquor.content.FeatureData

data class LiquorInfo(
    val nameKo: String,
    val nameEn: String,
    val thumbnailUrl: String,
    var like: Int, // 좋아요 수
    val stockCount: Int,
    val reviewCount: Int, // 리뷰 수
    val rating: Float, // 별점 (5점 만 점)
    val brandCode: BrandCode,
    val status: List<LiquorStatus>? = null, // 주류 유형
    val sellingStatus: LiquorSellingStatus, // 판매 상태
    val type: LiquorType, // 주류 유형
    val whiskyType: List<WhiskyType>? = null, // 위스키 유형
    val priceKrw: Int, // 판매 금액, 원화
    val discountRate: Float, // 할인율 %, int only
    val operatorComment: List<FeatureData>, // 운영진 소갯말
    val features: List<FeatureData>, // 제품 공식 설명
    val capacityToMl: Float, // ml 단위 용량
    val alcoholByVolume: Float, // 도수 %
    val aromaCode: List<LiquorExpressionCode>, // 향 (LiquorExpressionCode 표 참조)
    val tasteCode: List<LiquorExpressionCode>, // 맛 (LiquorExpressionCode 표 참조)
    val finishCode: List<LiquorExpressionCode>, // 여운 (LiquorExpressionCode 표 참조)
)