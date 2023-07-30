package com.season.winter.liquor.liquorInfo

import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.content.FeatureData

data class LiquorInfo(

    val identify: Int,
    val nameKo: String,
    val nameEn: String,
    val capacityToMl: Float, // ml 단위 용량
    val alcoholByVolume: Float, // 도수 %
    val thumbnailUrl: String,
    val thumbnailFileName: String? = null,

    var wishCount: Int, // 누적 위시 리스트 등록 수
    val reviewCount: Int, // 리뷰 수
    val rating: Float, // 별점 (5점 만 점)

    val brandCode: BrandInfo, // 제조사 정보
    val liquorType: LiquorType, // 주류 유형
    val liquorStatus: List<LiquorStatus>? = null, // 현재 강조할 상태
    val whiskyType: List<WhiskyType>? = null, // 위스키 유형

    val priceKrw: Int, // 판매 금액, 원화
    val discountRate: Float, // 할인율 %, int only

    val operatorComment: List<FeatureData>, // 운영진 소갯말
    val features: List<FeatureData>, // 제품 공식 설명

    val aromaCode: List<LiquorExpressionCode>, // 향 (LiquorExpressionCode 표 참조)
    val tasteCode: List<LiquorExpressionCode>, // 맛 (LiquorExpressionCode 표 참조)
    val finishCode: List<LiquorExpressionCode>, // 여운 (LiquorExpressionCode 표 참조)
)