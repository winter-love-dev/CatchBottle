package com.season.winter.common.constants

enum class TimeVariable(
    val value: Long
) {
    Zero(0L), // 0초
    Min1(60L), // 1분
    Min15(900L), // 15분
    Min20(1_200L), // 20분
    Min25(1_500L), // 25분
    Min30(1_800L), // 30분
    Hour1(3_600L), // 1시간
}