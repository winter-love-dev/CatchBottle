package com.season.winter.screen.fragment.navigationMain.home.local

import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.brand.CountryCode
import com.season.winter.liquor.dummy.LiquorInfoDummyGenerator
import com.season.winter.liquor.liquorInfo.filter.LiquorFilterOption
import com.season.winter.liquor.liquorInfo.LiquorStatus
import com.season.winter.liquor.liquorInfo.WhiskyType
import com.season.winter.ui.model.fragment.home.BannerData
import com.season.winter.ui.model.fragment.home.HomeItem
import com.season.winter.ui.model.fragment.home.HomeItemType
import com.season.winter.ui.model.fragment.home.ShortcutMenuData
import com.season.winter.ui.model.fragment.home.ShortcutMenuEvent
import javax.inject.Inject

class HomeNavigationDummyDao @Inject constructor() {

    private val liquorInfoDummy = LiquorInfoDummyGenerator()

    init {

        LiquorFilterOption.initFilter(
            liquorInfoDummy.getLiquorListAll()
        )
    }

    val bannerData = BannerData(
        imageUrls = listOf("", "", "")
    )

    private val liquorInfoDummyGenerator = LiquorInfoDummyGenerator()
    val liquorListAll = liquorInfoDummyGenerator.getLiquorListAll()

    val shortcutMenuData = listOf(
        ShortcutMenuData(
            event = ShortcutMenuEvent.Best,
            thumbImageUrl = "",
            title = "베스트",
        ),
        ShortcutMenuData(
            event = ShortcutMenuEvent.Discount,
            thumbImageUrl = "",
            title = "할인",
        ),
        ShortcutMenuData(
            event = ShortcutMenuEvent.New,
            thumbImageUrl = "",
            title = "신상품",
        ),
        ShortcutMenuData(
            event = ShortcutMenuEvent.Draw,
            thumbImageUrl = "",
            title = "응모",
        ),
        ShortcutMenuData(
            event = ShortcutMenuEvent.FirstComeFirstServed,
            thumbImageUrl = "",
            title = "선착순",
        ),
        ShortcutMenuData(
            event = ShortcutMenuEvent.MDPick,
            thumbImageUrl = "",
            title = "MD픽",
        ),
        ShortcutMenuData(
            event = ShortcutMenuEvent.DirectShipping,
            thumbImageUrl = "",
            title = "집앞배송",
        ),
    )

    val mainList = listOf(
        HomeItem(
            type = HomeItemType.SearchBar
        ),
        HomeItem(type = HomeItemType.Banner),
        HomeItem(type = HomeItemType.ShortcutMenu),
        HomeItem(
            type = HomeItemType.LiquorGrouping,
            title = "스토어 주간 BEST",
            subTitle = "지금 CatchBottle에서 가장 인기있는 상품",
            liquorGroupingOption = LiquorFilterOption.ByLiquorStatus.generateFilterOption(
                liquorStatus = listOf(
                    LiquorStatus.WeeklyBest
                )
            ),
        ),
        HomeItem(
            type = HomeItemType.LiquorGrouping,
            title = "쓰리소사이어티스 위스키 기획전",
            subTitle = "CatchBottle에 입점한 첫 K-위스키 브랜드",
            liquorGroupingOption = LiquorFilterOption.ByBrand.generateFilterOption(
                brand = BrandInfo.ThreeSocietiesDistillery
            ),
        ),
        HomeItem(
            type = HomeItemType.LiquorGrouping,
            title = "아메리칸 위스키 모아보기",
            subTitle = "뜨거운 녀석들 \uD83D\uDD25",
            liquorGroupingOption = LiquorFilterOption.ByCountry.generateFilterOption(
                countryCode = CountryCode.US
            ),
        ),
        HomeItem(
            type = HomeItemType.LiquorGrouping,
            title = "셰리 위스키 모아보기",
            subTitle = "셰리 캐스크가 만드는 달콤 꾸덕한 맛",
            liquorGroupingOption = LiquorFilterOption.ByWhiskyType.generateFilterOption(
                whiskyType = listOf(
                    WhiskyType.Sherry
                )
            ),
        ),
        HomeItem(
            type = HomeItemType.LiquorGrouping,
            title = "모든 위스키 모아보기",
            subTitle = "CatchBottle 에서 구매 가능한 위스키 모음",
            liquorGroupingOption = LiquorFilterOption.All,
        ),
        HomeItem(
            type = HomeItemType.Footer
        )
    )
}