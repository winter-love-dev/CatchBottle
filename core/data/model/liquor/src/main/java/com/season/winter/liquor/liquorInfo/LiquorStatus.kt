package com.season.winter.liquor.liquorInfo

enum class LiquorStatus {
    LimitedEdition, // 한정판
    Draw, // 응모 제품
    FirstComeFirstServed, // 소량 재고, 선착순 판매
    WeeklyBest, // 주간 베스트 셀러 상품
    MonthlyBest, // 월간 베스트 셀러 상품
    SteadySeller, // 오랜 기간 꾸준히 잘 팔리는 상품
    Discount, // 할인 제품
    ;
}