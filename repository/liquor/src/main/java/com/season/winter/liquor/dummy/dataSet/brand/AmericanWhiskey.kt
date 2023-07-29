package com.season.winter.liquor.dummy.dataSet.brand

import com.season.winter.liquor.liquorInfo.LiquorType
import com.season.winter.liquor.brand.Brand
import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.content.FeatureData
import com.season.winter.liquor.content.FeatureType

val wildTurkey = Brand(
    brandCode = BrandInfo.WildTurkey,
    productType = listOf(
        LiquorType.Whisky
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
    brandCode = BrandInfo.KirklandWhisky,
    productType = listOf(
        LiquorType.Whisky
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
    brandCode = BrandInfo.JackDaniels,
    productType = listOf(
        LiquorType.Whisky
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