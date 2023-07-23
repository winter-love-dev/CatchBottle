package com.season.winter.model.liquorShop

data class LiquorShop(
    val dealerId: String,
    val shopType: ShopType,
    val shopName: String,
    val openTime: String, // 매장 오픈 시간
    val closeTime: String, // 영업 종료 시간
    val location: String, // 주소
    val detailLocation: String, // 상세 주소
)
