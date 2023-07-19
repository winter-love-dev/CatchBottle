package com.season.winter.designsystem.typography

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.season.winter.designsystem.R
import com.season.winter.designsystem.typography.base.FontFamily
import com.season.winter.designsystem.typography.base.FontSize
import com.season.winter.designsystem.typography.base.Weight

enum class CBTypography(
    val fontFamily: Int,
    val weight: Int,
    val size: Int,
) {
    HeadXs(
        FontFamily.BoldResource,
        Weight.W600.value,
        FontSize.Xs.headSize
    ),
    HeadS(
        FontFamily.BoldResource,
        Weight.W700.value,
        FontSize.S.headSize
    ),
    HeadM(
        FontFamily.BoldResource,
        Weight.W700.value,
        FontSize.M.headSize
    ),
    HeadL(
        FontFamily.BoldResource,
        Weight.W700.value,
        FontSize.L.headSize
    ),
    BodyS(
        FontFamily.MediumResource,
        Weight.W500.value,
        FontSize.S.bodySize
    ),
    BodyM(
        FontFamily.MediumResource,
        Weight.W500.value,
        FontSize.M.bodySize
    ),
    BodyL(
        FontFamily.MediumResource,
        Weight.W500.value,
        FontSize.L.bodySize
    ),
    CaptionS(
        FontFamily.RegularResource,
        Weight.W500.value,
        FontSize.S.captionSize
    ),
    CaptionM(
        FontFamily.RegularResource,
        Weight.W500.value,
        FontSize.M.captionSize
    ),
    ButtonFirst(
        FontFamily.RegularResource,
        BodyM.weight,
        BodyM.size,
    ),
    ButtonSecond(
        FontFamily.RegularResource,
        BodyS.weight,
        BodyS.size,
    ),
    InputPlaceHolder(
        FontFamily.RegularResource,
        BodyS.weight,
        BodyM.size,
    ),
    InputLabel(
        FontFamily.RegularResource,
        CaptionM.weight,
        CaptionM.size
    ),
    InputCaption(
        FontFamily.RegularResource,
        CaptionM.weight,
        CaptionM.size
    ),
    ListTitle(
        FontFamily.RegularResource,
        BodyM.weight,
        BodyM.size
    ),
    ListDescription(
        FontFamily.RegularResource,
        CaptionM.weight,
        CaptionM.size
    ),
    ListLabel(
        FontFamily.RegularResource,
        CaptionM.weight,
        CaptionM.size
    ),
    ;

    companion object {

        fun getDefaultSize(context: Context): Float {
            return context.resources.getDimension(BodyM.size)
        }

        fun getDefaultHeadSize(context: Context): Float {
            return context.resources.getDimension(HeadXs.size)
        }

        fun getHeadInfo(textSize: Int = 2): CBTypography {
            return when (textSize) {
                0 -> HeadXs
                1 -> HeadS
                2 -> HeadM
                3 -> HeadL
                else -> HeadM
            }
        }

        fun getBodyInfo(textSize: Int = 2): CBTypography {
            return when (textSize) {
                0 -> BodyS
                1 -> BodyM
                2 -> BodyL
                else -> BodyM
            }
        }

        fun getCaptionInfo(textSize: Int = 2): CBTypography {
            return when (textSize) {
                0 -> CaptionS
                1 -> CaptionM
                else -> CaptionM
            }
        }

        fun getFontRes(context: Context, cbTypography: CBTypography): Typeface {
            return ResourcesCompat.getFont(context, cbTypography.fontFamily) ?: getDefaultFontRes(context)
        }

        private fun getDefaultFontRes(context: Context): Typeface {
            return ResourcesCompat.getFont(context, BodyM.fontFamily)!!
        }

        val TypedArray.textViewType get(): CBTypography {
            return when (getInt(R.styleable.CBTextView_cb_text_view_type, 0)) {
                0 -> HeadXs
                1 -> HeadS
                2 -> HeadM
                3 -> HeadL
                4 -> BodyS
                5 -> BodyM
                6 -> BodyL
                7 -> CaptionS
                8 -> CaptionM
                else -> BodyM
            }
        }
    }
}