package com.season.winter.model.credentials

enum class UserType(
    val number: Int,
    val role: String,
    val permissionDescription: String,
) {
    General(
        0,
        "일반 유저",
        "주류 구매"
    ),
    Dealer(
        1,
        "대리점 점주",
        "매장 운영 및 주류 판매"
    ),
    HeadQuarters(
        2,
        "'캐치 보틀' 플랫폼 본부 직원",
        "주류 유통 관리, '캐치 보틀' 서비스 총괄 및 매장 관리"
    ),
    TopManager(
        3,
        "최고 관리자",
        "최고 권한 및 총괄"
    ),
}
