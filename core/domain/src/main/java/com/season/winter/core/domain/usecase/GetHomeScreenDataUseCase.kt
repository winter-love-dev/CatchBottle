package com.season.winter.core.domain.usecase

import com.season.winter.core.domain.database.RemoteConfigDao
import com.season.winter.core.domain.entity.HomeItem
import com.season.winter.core.domain.entity.HomeItemType
import com.season.winter.core.domain.repository.DummyLiquorInfoRepository
import com.season.winter.liquor.brand.BrandInfo
import com.season.winter.liquor.brand.CountryCode
import com.season.winter.liquor.filter.LiquorFilterOption
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.LiquorStatus
import com.season.winter.liquor.liquorInfo.WhiskyType
import javax.inject.Inject

class GetHomeScreenDataUseCase @Inject constructor(
    private val dummyLiquorInfoRepository: DummyLiquorInfoRepository,
    private val remoteConfigDao: RemoteConfigDao
) {

    private var mainList: List<HomeItem> = emptyList()
    private var liquorListAll: List<LiquorInfo> = emptyList()

    suspend operator fun invoke(): List<HomeItem> {
        // operator: overloading, plus 와 같이 원래 있던 기능을 재정의.
        // invoke (호출): 바로 결과를 리턴할 수 있게 invoke 를 overloading 한다.
        return assembleHomeScreenData()
    }

    private suspend fun assembleHomeScreenData(): List<HomeItem> {

        if (liquorListAll.isEmpty()) {
            liquorListAll = dummyLiquorInfoRepository.liquorListAll()
            LiquorFilterOption.initFilter(liquorListAll)
        }

        if (mainList.isEmpty())
            mainList = getMainListDataSet()

        val setBanner: Boolean = mainList.find {
            it.type == HomeItemType.Banner
        }?.bannerItems?.isNotEmpty() == true

        if (setBanner.not()) {
            val bannerList = remoteConfigDao.getBannerAll()
            mainList.find {
                it.type == HomeItemType.Banner
            }?.bannerItems = bannerList
        }

        return mainList
    }

    private fun getMainListDataSet(): List<HomeItem> {
        return listOf(
            HomeItem(
                type = HomeItemType.SearchBar
            ),
            HomeItem(
                type = HomeItemType.Banner,
                bannerItems = emptyList()
            ),
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
}