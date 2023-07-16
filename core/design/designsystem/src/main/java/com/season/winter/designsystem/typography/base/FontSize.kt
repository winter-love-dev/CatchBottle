package com.season.winter.designsystem.typography.base

import com.season.winter.designsystem.R

enum class FontSize(
    private val head: Int? = null,
    private val body: Int? = null,
    private val caption: Int? = null,
) {
    Xs(
        head = R.dimen.font_head_xs,
    ),
    S(
        head = R.dimen.font_head_s,
        body = R.dimen.font_body_s,
        caption = R.dimen.font_caption_s,
    ),
    M(
        head = R.dimen.font_head_m,
        body = R.dimen.font_body_m,
        caption = R.dimen.font_caption_m,
    ),
    L(
        head = R.dimen.font_head_l,
        body = R.dimen.font_body_l,
    ),
    Xl(),
    Xxl(),
    ;

    val headSize: Int get() {
        return head ?: M.body!!
    }

    val bodySize: Int get() {
        return body ?: M.body!!
    }

    val captionSize: Int get() {
        return caption ?: M.caption!!
    }

//    val value: Int get() = when(this) {
//        Xs -> R.dimen.font_size_xs
//        S -> R.dimen.font_size_s
//        M -> R.dimen.font_size_m
//        L -> R.dimen.font_size_l
//        Xl -> R.dimen.font_size_xl
//        Xxl -> R.dimen.font_size_xxl
//    }
}
