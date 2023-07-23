package com.season.winter.model.alcoholInfo

/*
* Whisky, Whiskey 차이
*
* (Whisky)
* 스카치 위스키(Scotch Whisky),
* 캐나다 위스키(Canadian Whisky),
* 일본 위스키(Japanese Whisky)
* 에는 ‘Whisky’를 사용하는 반면
*
* (Whiskey)
* 아일랜드 위스키(Irish Whiskey),
* 버번 위스키(Bourbon Whiskey),
* 테네시 위스키(Tennessee Whiskey)에는
* ‘Whiskey’를 사용하고 또 선호한다.
*/

enum class AlcoholType(
    val type: Int,
    val roleKo: String,
    val roleEn: String,
) {
    Whisky(
        0,
        "위스키",
        "Whisky"
    ),
    Brandy(
        1,
        "브랜디",
        "Brandy"
    ),
    Vodka(
        2,
        "보드카",
        "Vodka"
    ),
    Wine(
        3,
        "와인",
        "Wine"
    ),
    Beer(
        4,
        "맥주",
        "Beer"
    ),
    Sake(
        5,
        "사케",
        "Sake"
    ),
    Rum(
        6,
        "럼",
        "Rum"
    ),
    Gin(
        7,
        "진",
        "Gin"
    ),
    TraditionalKorea(
        8,
        "한국 전통주",
        "Traditional Korea"
    )
}

