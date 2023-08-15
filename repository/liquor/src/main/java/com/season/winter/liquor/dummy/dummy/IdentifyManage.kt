package com.season.winter.liquor.dummy.dummy

const val AmericanLiquorIdentify = 10
const val KoreanLiquorIdentify = 20
const val ScotchLiquorIdentify = 30

fun getAmericanLiquorIdentify(number: Int): Int {
    return "$AmericanLiquorIdentify$number".toInt()
}

fun getKoreanLiquorIdentify(number: Int): Int {
    return "$KoreanLiquorIdentify$number".toInt()
}

fun getScotchLiquorIdentify(number: Int): Int {
    return "$ScotchLiquorIdentify$number".toInt()
}