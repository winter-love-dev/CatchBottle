package com.season.winter.liquor.brand

enum class CountryCode(
    number: Int,
    code: String,
    ko: String,
    en: String
) {
    KR(
        0,
        "KR",
        "대한민국",
        "Korea",
    ),
    UK(
        1,
        "UK",
        "영국",
        "United Kingdom of Great Britain and Northern Ireland",
    ),
    UKScotland(
        2,
        "UK",
        "스코틀랜드",
        "Scotlan",
    ),
    US(
        3,
        "US",
        "미국",
        "United States of America",
    ),
    JP(
        4,
        "JP",
        "일본",
        "Japan",
    ),
    IE(
        5,
        "IE",
        "아일랜드",
        "Ireland",
    ),
    ;
}