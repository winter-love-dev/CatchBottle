package com.season.winter.common.extention.view.glide

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.season.winter.core_design_resource.R as ResourceModuleR

fun ImageView.setImageFromUrl(imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    Glide.with(context).load(imageUrl)
//        .error(ResourceModuleR.drawable.logo_icon_small)
//        .fallback(ResourceModuleR.drawable.logo_icon_small)
        .placeholder(ResourceModuleR.drawable.logo_icon_small)
//        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

}