package com.season.winter.liquor.liquorInfo

// Expression = 주류의 향, 맛, 피니쉬(마신 뒤 여운) 표현 종류
enum class LiquorExpressionCode(
    val number: Int,
    val Expression: String,
) {
    Vanilla(
        0,
        "바닐라"
    ),
    Banana(
        1,
        "바나나"
    ),
    WhiteGrape(
        2,
        "백건 포도"
    ),
    Peach(
        3,
        "복숭아"
    ),
    Apple(
        4,
        "사과"
    ),
    Plum(
        5,
        "자두"
    ),
    Honeyed(
        6,
        "달콤한"
    ),
    Rich(
        7,
        "풍부한"
    ),
    StewedFruit(
        8,
        "졸인 과일"
    ),
    RoastedWalnuts(
        9,
        "구운 호두"
    ),
    Chocolate(
        10,
        "초콜릿"
    ),
    Orange(
        11,
        "오렌지"
    ),
    DarkChocolate(
        12,
        "다크 초콜릿"
    ),
    DemeraraSugar(
        13,
        "데메라라 설탕"
    ),
    Cinnamon(
        14,
        "시나몬"
    ),
    Fruit(
        15,
        "과일"
    ),
    Rye(
        16,
        "호밀"
    ),
    Nuts(
        17,
        "견과류"
    ),
    Sherry(
        18,
        "셰리"
    ),
    Oak(
        19,
        "오크"
    ),
    Spicy(
        20,
        "스파이시"
    ),
    KoreanSpice(
        21,
        "한국적인 스파이스"
    ),
    Spice(
        22,
        "향신료"
    ),
    Caramel(
        23,
        "캐러멜"
    ),
    Subtle(
        24,
        "미묘한"
    ),
    Toffee(
        25,
        "토피"
    ),
    Forest(
        26,
        "숲"
    ),
    LongAfterglow(
        27,
        "긴여운"
    ),
    Ginger(
        28,
        "생강"
    ),
    Mocha(
        29,
        "모카"
    ),
    Molasses(
        30,
        "당밀"
    ),
    Intense(
        31,
        "강렬한"
    ),
    DriedFruit(
        32,
        "말린 과일"
    ),
    Creamy(
        33,
        "크리미"
    ),
    Licorice(
        34,
        "감초"
    ),
    Coconut(
        35,
        "코코넛"
    ),
    Malt(
        36,
        "몰트"
    ),
    BrownSugar(
        37,
        "흑설탕"
    ),
    ;

}

