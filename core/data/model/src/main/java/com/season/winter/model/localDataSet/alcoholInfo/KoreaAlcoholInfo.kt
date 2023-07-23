package com.season.winter.model.localDataSet.alcoholInfo

import com.season.winter.model.alcoholInfo.AlcoholExpressionCode
import com.season.winter.model.alcoholInfo.AlcoholInfo
import com.season.winter.model.alcoholInfo.AlcoholType
import com.season.winter.model.alcoholInfo.WhiskyType
import com.season.winter.model.brand.BrandCode
import com.season.winter.model.content.FeatureData
import com.season.winter.model.content.FeatureType
import com.season.winter.model.localDataSet.brand.kimChangSooDistillery

val kiOneBatch1 = AlcoholInfo(
    nameKo = "기원 배치 1",
    nameEn = "KI ONE Batch 1",
    like = 0,
    brandCode = BrandCode.KimChangSooDistillery,
    productType = AlcoholType.Whisky,
    whiskyType = WhiskyType.SingleMalt,
    priceKrw = 0,
    discountRate = 0.0f,
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
        AlcoholExpressionCode.Apple,
        AlcoholExpressionCode.Vanilla,
        AlcoholExpressionCode.WhiteGrape,
    ),
    tasteCode = listOf(
        AlcoholExpressionCode.Apple,
        AlcoholExpressionCode.Vanilla,
        AlcoholExpressionCode.WhiteGrape,
    ),
    finishCode = listOf(
        AlcoholExpressionCode.Apple,
        AlcoholExpressionCode.Vanilla,
        AlcoholExpressionCode.WhiteGrape,
    ),
)

val kiOneBatch2 = AlcoholInfo(
    nameKo = "기원 배치 2",
    nameEn = "KI ONE Batch 2",
    like = 0,
    brandCode = BrandCode.KimChangSooDistillery,
    productType = AlcoholType.Whisky,
    priceKrw = 0,
    discountRate = 0.0f,
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
        AlcoholExpressionCode.Apple,
        AlcoholExpressionCode.Vanilla,
        AlcoholExpressionCode.WhiteGrape,
    ),
    tasteCode = listOf(
        AlcoholExpressionCode.Apple,
        AlcoholExpressionCode.Vanilla,
        AlcoholExpressionCode.WhiteGrape,
    ),
    finishCode = listOf(
        AlcoholExpressionCode.Apple,
        AlcoholExpressionCode.Vanilla,
        AlcoholExpressionCode.WhiteGrape,
    ),
)

val koreaAlcoholInfoList = listOf(
    kiOneBatch1,
    kiOneBatch2
)