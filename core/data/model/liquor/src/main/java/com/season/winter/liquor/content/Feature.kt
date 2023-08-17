package com.season.winter.liquor.content

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.season.winter.designsystem.color.CBColor
import com.season.winter.designsystem.typography.CBTypography
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class FeatureType(

    @ColumnInfo(name = "type", defaultValue = "0")
    @SerialName("type") val identify: Int,
){
    @SerialName("0") Text(0),
    @SerialName("1") ImageUrl(1),
    @SerialName("2") YouTubeVideoUrl(2),
    ;

    companion object {
        fun toType(identify: Int): FeatureType? {
            return when(identify) {
                0 -> Text
                1 -> ImageUrl
                2 -> YouTubeVideoUrl
                else -> null
            }
        }
    }
}

@Serializable
@Entity(
    tableName = "content_feature",
    indices = [Index("feature_id")],
)
data class FeatureData(

    @ColumnInfo(name = "type")
    val type: FeatureType,

    @ColumnInfo(name = "color_res")
    val colorRes: Int = CBColor.Black.value, // textColor

    @ColumnInfo(name = "font_family")
    val fontFamily: CBTypography = CBTypography.BodyM,

    @ColumnInfo(name = "source")
    val source: String, // text or url

    @ColumnInfo(name = "click_action_url")
    val clickActionUrl: String? = null, // 텍스트 or 이미지 클릭했을 때의 액션 지정
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "feature_id")
    var sortId: Long = 0
}
