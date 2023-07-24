package com.season.winter.liquor.localDataSet.liquorInfo

import com.season.winter.liquor.liquorInfo.LiquorExpressionCode
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.liquorInfo.WhiskyType
import com.season.winter.liquor.brand.BrandCode
import com.season.winter.liquor.content.FeatureData
import com.season.winter.liquor.content.FeatureType
import com.season.winter.liquor.liquorInfo.LiquorSellingStatus

val russellsReserveSingleBarrel = LiquorInfo(
    nameKo = "러셀 리저브 싱글 베럴",
    nameEn = "Russell’s Reserve Single Barrel",
    like = 0,
    brandCode = BrandCode.Glenmorangie,
    type = LiquorType.Whisky,
    whiskyType = listOf(
        WhiskyType.Bourbon
    ),
    priceKrw = 0,
    discountRate = 0.0f,
    thumbnailUrl = "",
    stockCount = 0,
    sellingStatus = LiquorSellingStatus.Show,
    rating = 0f, // 별점 (5점 만 점)
    reviewCount = 0, // 리뷰 수
    operatorComment = listOf(
        FeatureData(
            type = FeatureType.Text,
            source = """
                아버지에서 아들까지, 내공이 새겨진 한 병의 보틑
                
                러셀 리저브 시리즈는 버번 위스키 명예의 전달(Kentucky Bourbon Hall of Fame)에 이름을 올린 버번 위스키의 전설같은 존재, Jimmy Russell과 Eddie Russell 부자에 의해 만들어졌습니다. 이들의 첫 번째 과업은 금주법 이전부터 이어져 온 와일드 터키 증류소 버번 위스키의 맛을 전승하는 것이었습니다. 하지만 시간이 지남에 따라 소비자들은 더 다양한 제품을 원하게 되었고, 그에 따라 이들은 와일드 처키 위스키의 본질을 지키면서도 소비자가 원하는, 그리고 자신들이 새롭게 시도하고 싶었던 제품을 내는 방식을 따르게 됩니다. 그렇게 탄생한 것이 그들의 이름을 딴 ‘러셀 리저브(Russell’s Reserve)’라는 스몰 배치 버번 브랜드입니다.
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

val americanLiquorInfoList = listOf(
    russellsReserveSingleBarrel
)