package com.season.winter.liquor.localDataSet.liquorInfo

import com.season.winter.liquor.liquorInfo.LiquorExpressionCode
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.liquorInfo.WhiskyType
import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.content.FeatureData
import com.season.winter.liquor.content.FeatureType
import com.season.winter.liquor.dummy.getKoreanLiquorIdentify
import com.season.winter.liquor.liquorInfo.LiquorStatus

val kiOneBatch1 = LiquorInfo(
    identify = getKoreanLiquorIdentify(0),
    nameKo = "기원 배치 1",
    nameEn = "KI ONE Batch 1",
    wishCount = 0,
    brandCode = BrandInfo.KimChangSooDistillery,
    liquorType = LiquorType.Whisky,
    whiskyType = listOf(
        WhiskyType.SingleMalt
    ),
    priceKrw = 0,
    thumbnailUrl = "",
    rating = 0f, // 별점 (5점 만 점)
    reviewCount = 0, // 리뷰 수
    discountRate = 0.0f,
    liquorStatus = listOf(
        LiquorStatus.LimitedEdition,
    ),
    operatorComment = listOf(
        FeatureData(
            type = FeatureType.Text,
            source = """
                기원 (KI ONE), ‘시작’과 ‘바람’
                The Fist Korean Single Malt Whiskey

                쓰리소사이어티스 (Three Societies) 증류소의 기원(KI ONE)은 ‘시작’과 ‘바람’이라는 두 가지 뜻을 품고 있습니다. 한국 최초 싱글몰트 위스키의 ‘시작’인 브랜드로서 그 무게감을 진중하게 느끼고, 세계에서 인정받는 위스키를 만들고자 하는 많은 이들의 ‘바람’을 담았습니다.
            """.trimIndent()
        )
    ),
    features = listOf(
        FeatureData(
            type = FeatureType.ImageUrl,
            source = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fm.sedaily.com%2FNewsView%2F29LLG42LT2&psig=AOvVaw2Yoges-CeYdpuIUa_Le8ao&ust=1690166639893000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKiAisTno4ADFQAAAAAdAAAAABAE"
        ),
        FeatureData(
            type = FeatureType.YouTubeVideoUrl,
            source = "https://youtu.be/JukrgH90Sz8?si=0FtNeWtkvZcU0u8Q"
        )
    ),
    capacityToMl = 700f,
    alcoholByVolume = 40f,
    aromaCode = listOf(
        LiquorExpressionCode.Apple,
        LiquorExpressionCode.Vanilla,
        LiquorExpressionCode.WhiteGrape,
    ),
    tasteCode = listOf(
        LiquorExpressionCode.Apple,
        LiquorExpressionCode.Vanilla,
        LiquorExpressionCode.WhiteGrape,
    ),
    finishCode = listOf(
        LiquorExpressionCode.Apple,
        LiquorExpressionCode.Vanilla,
        LiquorExpressionCode.WhiteGrape,
    ),
)

val kiOneBatch2 = LiquorInfo(
    identify = getKoreanLiquorIdentify(1),
    nameKo = "기원 배치 2",
    nameEn = "KI ONE Batch 2",
    wishCount = 0,
    brandCode = BrandInfo.KimChangSooDistillery,
    liquorType = LiquorType.Whisky,
    thumbnailUrl = "",
    rating = 0f, // 별점 (5점 만 점)
    reviewCount = 0, // 리뷰 수
    priceKrw = 0,
    discountRate = 0.0f,
    liquorStatus = listOf(
        LiquorStatus.WeeklyBest,
        LiquorStatus.Discount,
    ),
    operatorComment = listOf(
        FeatureData(
            type = FeatureType.Text,
            source = """
                기원 (KI ONE), ‘시작’과 ‘바람’
                The Fist Korean Single Malt Whiskey
                
                쓰리소사이어티스 (Three Societies) 증류소의 기원(KI ONE)은 ‘시작’과 ‘바람’이라는 두 가지 뜻을 품고 있습니다. 한국 최초 싱글몰트 위스키의 ‘시작’인 브랜드로서 그 무게감을 진중하게 느끼고, 세계에서 인정받는 위스키를 만들고자 하는 많은 이들의 ‘바람’을 담았습니다.
                
                ’기원 배치2’는 당화, 발효, 증류, 숙성 등 모든 생산 과정이 한국의 사계정 속에서 이루어진 덕분에 독특한 풍미를 가집니다.
            """.trimIndent()
        )
    ),
    features = listOf(
        FeatureData(
            type = FeatureType.ImageUrl,
            source = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fm.sedaily.com%2FNewsView%2F29LLG42LT2&psig=AOvVaw2Yoges-CeYdpuIUa_Le8ao&ust=1690166639893000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKiAisTno4ADFQAAAAAdAAAAABAE"
        ),
        FeatureData(
            type = FeatureType.YouTubeVideoUrl,
            source = "https://youtu.be/JukrgH90Sz8?si=0FtNeWtkvZcU0u8Q"
        )
    ),
    capacityToMl = 700f,
    alcoholByVolume = 40f,
    aromaCode = listOf(
        LiquorExpressionCode.Apple,
        LiquorExpressionCode.Vanilla,
        LiquorExpressionCode.WhiteGrape,
    ),
    tasteCode = listOf(
        LiquorExpressionCode.Apple,
        LiquorExpressionCode.Vanilla,
        LiquorExpressionCode.WhiteGrape,
    ),
    finishCode = listOf(
        LiquorExpressionCode.Apple,
        LiquorExpressionCode.Vanilla,
        LiquorExpressionCode.WhiteGrape,
    ),
)

val koreaLiquorInfoList = listOf(
    kiOneBatch1,
    kiOneBatch2
)