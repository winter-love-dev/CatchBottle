package com.season.winter.model.brand

enum class BrandCode(
    val number: Int,
    val nameKo: String,
    val nameEn: String,
    val countryCode: CountryCode
) {
    KimChangSooDistillery(
        0,
        "김창수 위스키 증류소",
        "Kim Chang Soo Distillery",
        CountryCode.KR
    ),
    WildTurkey(
        1,
        "와일드 터키",
        "Wild Turkey",
        CountryCode.US
    ),
    KirklandWhisky(
        2,
        "커클랜드 위스키",
        "Kirkland Whisky",
        CountryCode.US
    ),
    JackDaniels(
        3,
        "잭다니엘스",
        "jackDaniels",
        CountryCode.US
    ),
    Jameson(
        4,
        "제임슨",
        "Jameson",
        CountryCode.IE
    ),
    Suntory(
        5,
        "산토리",
        "Suntory",
        CountryCode.JP
    ),
    HighlandPark(
        6,
        "하이랜드 파크",
        "Highland Park",
        CountryCode.UKScotland
    ),
    RoyalSalute(
        7,
        "로얄 살루트",
        "Royal Salute",
        CountryCode.UKScotland
    ),
    TheGlenlivet(
        8,
        "글렌리벳",
        "The Glenlivet",
        CountryCode.UKScotland
    ),
    Balvenie(
        9,
        "발베니",
        "Balvenie",
        CountryCode.UKScotland
    ),
    JimBeam(
        10,
        "짐빔",
        "Jim Beam",
        CountryCode.UKScotland
    ),
    ChivasRegal(
        11,
        "시바스리갈",
        "Chivas Regal",
        CountryCode.UKScotland
    ),
    TheMacallan(
        12,
        "맥켈란",
        "The Macallan",
        CountryCode.UKScotland
    ),
    Glenfiddich(
        13,
        "글렌피딕",
        "Glenfiddich",
        CountryCode.UKScotland
    ),
    Bells(
        14,
        "벨즈",
        "Bells",
        CountryCode.UKScotland
    ),
    JohnnieWalker(
        15,
        "조니워커",
        "Johnnie Walker",
        CountryCode.UKScotland
    ),
    Laphroaig(
        16,
        "라프로익",
        "Laphroaig",
        CountryCode.UKScotland
    ),
    Ballantines(
        17,
        "발렌타인",
        "Ballantine's",
        CountryCode.UKScotland
    ),
    Glenmorangie(
        18,
        "글렌모렌지",
        "Glenmorangie",
        CountryCode.UKScotland
    ),
    ;
}