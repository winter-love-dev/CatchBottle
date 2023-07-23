package com.season.winter.model.localDataSet.alcoholInfo

import com.season.winter.model.alcoholInfo.AlcoholExpressionCode
import com.season.winter.model.alcoholInfo.AlcoholInfo
import com.season.winter.model.alcoholInfo.AlcoholType
import com.season.winter.model.alcoholInfo.WhiskyType
import com.season.winter.model.brand.BrandCode
import com.season.winter.model.content.FeatureData
import com.season.winter.model.content.FeatureType

val theMacllan12ySherryOak = AlcoholInfo(
    nameKo = "맥켈란 12년 셰리 오크",
    nameEn = "The Macllan 12y Sherry Oak",
    like = 0,
    brandCode = BrandCode.TheMacallan,
    productType = AlcoholType.Whisky,
    whiskyType = WhiskyType.SingleMalt,
    priceKrw = 0,
    discountRate = 0.0f,
    operatorComment = listOf(
        FeatureData(
            type = FeatureType.Text,
            source = """
                세계 최상의 맥켈란 12년을 마실 기회가 생긴다면 놓치지 마라.
                
                포브스 매거진에서 위스키 전문가로 소개된 폴 파컬트. 그릐 스피릿 저널에서 맥캘란은 훌륭한 풍미와 맛을 가지고 있다고 극찬받았습니다. 이처럼 전문가의 평가가 아니더라도, 위스키를 즐기는 애호가들 사이에서 맥캘란은 위스키계의 명작으로 사랑받고 있는데요. 셰리 오크통에서 숙성시킨 ‘맥켈란 12년 셰리 오크’의 풍미는 전 세계적으로 찬사를 받고 있습니다.
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

val balvenieDoublewood12Yo = AlcoholInfo(
    nameKo = "발베니 더블우드 12년",
    nameEn = "Balvenie Doublewood 12yo",
    like = 0,
    brandCode = BrandCode.TheMacallan,
    productType = AlcoholType.Whisky,
    whiskyType = WhiskyType.SingleMalt,
    priceKrw = 0,
    discountRate = 0.0f,
    operatorComment = listOf(
        FeatureData(
            type = FeatureType.Text,
            source = "‘발베니 더블우드 12년’은 전 세계 최초로 버번 오크와 셰리 오크, 두 가지 오크통 숙성 기법으로 독특하고 매력적인 맛을 입고 비로소 완성되는 싱글몰트 위스키입니다. 먼저 아메리칸 버번 오크에서 12년 동안 깊은 부드러움과 바닐라의 풍미를 입을 후 셰리 와인 오크통에서 다시 약 6개월~10개월 동안 과일의 향긋함과 벌꿀의 달콤함이 더해지게 되죠. 바닐라향, 화려한 꽃향 그리고 달콤한 과일의 향기로 가득 찬 진한 황금빛 술 한잔은 혀끝에 감도는 부드러운 질갑을 시작으로 잘 조합된 견과류의 풍미와 시나몬의 스파이시한 맛, 꽤 오래 이어지는 따뜻한 여운을 선사합니다."
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

val glenmorangieLasanta12yo = AlcoholInfo(
    nameKo = "글렌모렌지 라산타 12년",
    nameEn = "Glenmorangie Lasanta 12yo",
    like = 0,
    brandCode = BrandCode.Glenmorangie,
    productType = AlcoholType.Whisky,
    whiskyType = WhiskyType.SingleMalt,
    priceKrw = 0,
    discountRate = 0.0f,
    operatorComment = listOf(
        FeatureData(
            type = FeatureType.Text,
            source = "‘글렌모렌지 라산타 12년’은 스코틀랜드의 게일어로 따뜻함과 열정을 의미하는 라산다 (Lasanta)처럼 우아하면서 풍부한 향을 자랑하는 풀바디 위스키입니다. 버번을 담았던 미국산 화이트 오크 캐스크에서 10년 숙성을 마친 후 올로로소 셰리 캐스크와 셰리의 왕이라 불리는 페드로 히메네스 캐스크에서 2년간 추가 숙성을 거쳤습니다. 진한 과일 향과 단맛을 자랑하며, 가볍지만 스파이시한 끝 맛이 매력적입니다."
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

val scotchAlcoholInfoList = listOf(
    theMacllan12ySherryOak,
    balvenieDoublewood12Yo,
    glenmorangieLasanta12yo
)