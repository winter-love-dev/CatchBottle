package com.season.winter.ui.model.dummy

import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.brand.CountryCode
import com.season.winter.liquor.dummy.LiquorInfoDummyGenerator
import com.season.winter.liquor.liquorInfo.LiquorStatus
import com.season.winter.liquor.liquorInfo.WhiskyType
import com.season.winter.liquor.liquorInfo.filter.LiquorFilterOption

class HomeUIDummyGenerator {

    private val liquorInfoDummy = LiquorInfoDummyGenerator()

    init {

        LiquorFilterOption.initFilter(
            liquorInfoDummy.getLiquorListAll()
        )
    }

    val bannerData = com.season.winter.ui.model.fragment.home.BannerData(
        imageUrls = listOf("", "", "")
    )

    val shortcutMenuData = listOf<com.season.winter.ui.model.fragment.home.ShortcutMenuData>(
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.Best,
            thumbImageUrl = "",
            title = "베스트",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.Discount,
            thumbImageUrl = "",
            title = "할인",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.New,
            thumbImageUrl = "",
            title = "신상품",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.Draw,
            thumbImageUrl = "",
            title = "응모",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.FirstComeFirstServed,
            thumbImageUrl = "",
            title = "선착순",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.MDPick,
            thumbImageUrl = "",
            title = "MD픽",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.MDPick,
            thumbImageUrl = "",
            title = "MD픽",
        ),
        com.season.winter.ui.model.fragment.home.ShortcutMenuData(
            event = com.season.winter.ui.model.fragment.home.ShortcutMenuEvent.DirectShipping,
            thumbImageUrl = "",
            title = "집앞배송",
        ),
    )

    val mainList: List<com.season.winter.ui.model.fragment.home.HomeItem> = listOf(
        com.season.winter.ui.model.fragment.home.HomeItem(type = com.season.winter.ui.model.fragment.home.HomeItemType.SearchBar),
        com.season.winter.ui.model.fragment.home.HomeItem(type = com.season.winter.ui.model.fragment.home.HomeItemType.Banner),
        com.season.winter.ui.model.fragment.home.HomeItem(type = com.season.winter.ui.model.fragment.home.HomeItemType.ShortcutMenu),
        com.season.winter.ui.model.fragment.home.HomeItem(
            type = com.season.winter.ui.model.fragment.home.HomeItemType.LiquorGrouping,
            title = "스토어 주간 BEST",
            subTitle = "지금 CatchBottle에서 가장 인기있는 상품",
            liquorGroupingOption = LiquorFilterOption.ByLiquorStatus.generateFilterOption(
                liquorStatus = listOf(
                    LiquorStatus.WeeklyBest
                )
            ),
        ),
        com.season.winter.ui.model.fragment.home.HomeItem(
            type = com.season.winter.ui.model.fragment.home.HomeItemType.LiquorGrouping,
            title = "김창수 위스키 기획전",
            subTitle = "CatchBottle에 입점한 첫 K-위스키 브랜드",
            liquorGroupingOption = LiquorFilterOption.ByBrand.generateFilterOption(
                brand = BrandInfo.KimChangSooDistillery
            ),
        ),
        com.season.winter.ui.model.fragment.home.HomeItem(
            type = com.season.winter.ui.model.fragment.home.HomeItemType.LiquorGrouping,
            title = "아메리칸 위스키 모아보기",
            subTitle = "뜨거운 녀석들 \uD83D\uDD25",
            liquorGroupingOption = LiquorFilterOption.ByCountry.generateFilterOption(
                countryCode = CountryCode.US
            ),
        ),
        com.season.winter.ui.model.fragment.home.HomeItem(
            type = com.season.winter.ui.model.fragment.home.HomeItemType.LiquorGrouping,
            title = "셰리 위스키 모아보기",
            subTitle = "셰리 캐스크가 만드는 달콤 꾸덕한 맛",
            liquorGroupingOption = LiquorFilterOption.ByWhiskyType.generateFilterOption(
                whiskyType = listOf(
                    WhiskyType.Sherry
                )
            ),
        ),
        com.season.winter.ui.model.fragment.home.HomeItem(
            type = com.season.winter.ui.model.fragment.home.HomeItemType.LiquorGrouping,
            title = "모든 위스키 모아보기",
            subTitle = "CatchBottle 에서 구매 가능한 위스키 모음",
            liquorGroupingOption = null,
        ),
        com.season.winter.ui.model.fragment.home.HomeItem(
            type = com.season.winter.ui.model.fragment.home.HomeItemType.Footer
        )
    )
}