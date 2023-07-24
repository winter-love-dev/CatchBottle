package com.season.winter.liquor.liquorShop

import com.season.winter.liquor.liquorInfo.LiquorType


enum class ShopType(
    val number: Int,
    val role: String,
    val productKind: Array<LiquorType>, // 취급 품목
) {
    General(
        0,
        "종합 주류 판매점",
        LiquorType.values()
    ),
    Whisky(
        1,
        "위스키 전문점",
        arrayOf(
            LiquorType.Whisky,
            LiquorType.Brandy,
            LiquorType.Vodka,
            LiquorType.Rum,
            LiquorType.Gin,
            LiquorType.Wine,
        )
    ),
    Wine(
        2,
        "와인 전문점",
        arrayOf(LiquorType.Wine)
    ),
    TraditionalKorea(
        3,
        "국내 전통주 취급 전문점",
        arrayOf(LiquorType.TraditionalKorea)
    ),
    ;
}