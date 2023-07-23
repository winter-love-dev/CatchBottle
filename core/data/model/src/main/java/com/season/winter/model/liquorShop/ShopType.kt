package com.season.winter.model.liquorShop

import com.season.winter.model.alcoholInfo.AlcoholType


enum class ShopType(
    val number: Int,
    val role: String,
    val productKind: Array<AlcoholType>, // 취급 품목
) {
    General(
        0,
        "종합 주류 판매점",
        AlcoholType.values()
    ),
    Whisky(
        1,
        "위스키 전문점",
        arrayOf(
            AlcoholType.Whisky,
            AlcoholType.Brandy,
            AlcoholType.Vodka,
            AlcoholType.Rum,
            AlcoholType.Gin,
            AlcoholType.Wine,
        )
    ),
    Wine(
        2,
        "와인 전문점",
        arrayOf(AlcoholType.Wine)
    ),
    TraditionalKorea(
        3,
        "국내 전통주 취급 전문점",
        arrayOf(AlcoholType.TraditionalKorea)
    ),
    ;
}