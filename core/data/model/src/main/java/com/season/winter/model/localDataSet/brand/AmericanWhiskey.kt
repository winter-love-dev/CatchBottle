package com.season.winter.model.localDataSet.brand

import com.season.winter.model.alcoholInfo.AlcoholType
import com.season.winter.model.brand.Brand
import com.season.winter.model.brand.BrandCode
import com.season.winter.model.brand.CountryCode
import com.season.winter.model.content.FeatureData
import com.season.winter.model.content.FeatureType

val wildTurkey = Brand(
    brandCode = BrandCode.WildTurkey,
    productType = listOf(
        AlcoholType.Whisky
    ),
    features = listOf(
        FeatureData(
            type = FeatureType.ImageUrl,
            source = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fm.sedaily.com%2FNewsView%2F29LLG42LT2&psig=AOvVaw2Yoges-CeYdpuIUa_Le8ao&ust=1690166639893000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKiAisTno4ADFQAAAAAdAAAAABAE",
        ),
        FeatureData(
            type = FeatureType.Text,
            source = "미국 위스키 증류소입니다",
        ),
        FeatureData(
            type = FeatureType.YouTubeVideoUrl,
            source = "https://youtu.be/JukrgH90Sz8?si=0FtNeWtkvZcU0u8Q",
        ),
    ),
)

val kirklandWhisky = Brand(
    brandCode = BrandCode.KirklandWhisky,
    productType = listOf(
        AlcoholType.Whisky
    ),
    features = listOf(
        FeatureData(
            type = FeatureType.ImageUrl,
            source = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fm.sedaily.com%2FNewsView%2F29LLG42LT2&psig=AOvVaw2Yoges-CeYdpuIUa_Le8ao&ust=1690166639893000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKiAisTno4ADFQAAAAAdAAAAABAE",
        ),
        FeatureData(
            type = FeatureType.Text,
            source = "미국 위스키 증류소입니다",
        ),
        FeatureData(
            type = FeatureType.YouTubeVideoUrl,
            source = "https://youtu.be/JukrgH90Sz8?si=0FtNeWtkvZcU0u8Q",
        ),
    ),
)

val jackDaniels = Brand(
    brandCode = BrandCode.JackDaniels,
    productType = listOf(
        AlcoholType.Whisky
    ),
    features = listOf(
        FeatureData(
            type = FeatureType.ImageUrl,
            source = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fm.sedaily.com%2FNewsView%2F29LLG42LT2&psig=AOvVaw2Yoges-CeYdpuIUa_Le8ao&ust=1690166639893000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKiAisTno4ADFQAAAAAdAAAAABAE",
        ),
        FeatureData(
            type = FeatureType.Text,
            source = "미국 위스키 증류소입니다",
        ),
        FeatureData(
            type = FeatureType.YouTubeVideoUrl,
            source = "https://youtu.be/JukrgH90Sz8?si=0FtNeWtkvZcU0u8Q",
        ),
    ),
)

val americanWhiskeyList = listOf(
    wildTurkey,
    kirklandWhisky,
    jackDaniels,
)