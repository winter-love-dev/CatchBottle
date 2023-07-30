package com.season.winter.common.extention.view.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.setImageFromUrl(imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    Glide.with(context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
