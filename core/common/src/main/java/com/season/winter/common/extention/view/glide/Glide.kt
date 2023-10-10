package com.season.winter.common.extention.view.glide

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.season.winter.common.util.device.getDisplaySizeCached
import com.season.winter.core_design_resource.R as ResourceModuleR

fun ImageView.setImageFromUrl(imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    Glide.with(context).load(imageUrl)
//        .error(ResourceModuleR.drawable.logo_icon_small)
//        .fallback(ResourceModuleR.drawable.logo_icon_small)
        //        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(ResourceModuleR.drawable.logo_icon_small)
        .into(this)
}

fun ImageView.setImageFromUrlWrapHeight(imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    val displaySize = context.getDisplaySizeCached()
    val displayPixelWidth = displaySize.pixelWidth

    val target = object : CustomTarget<Bitmap>() {
        override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
            layoutParams.apply {
                if (bitmap.width < displayPixelWidth) {
                    val distance = displayPixelWidth - bitmap.width
                    width = displayPixelWidth
                    height = bitmap.height + distance
                } else {
                    width = displayPixelWidth
                    height = bitmap.height
                }
            }
            setImageBitmap(bitmap)
        }
        override fun onLoadCleared(placeholder: Drawable?) {}
        override fun onLoadFailed(errorDrawable: Drawable?) {}
    }

    Glide.with(this)
        .asBitmap()
        .load(imageUrl)
        .into(target)
}