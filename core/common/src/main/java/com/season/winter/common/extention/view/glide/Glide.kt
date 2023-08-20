package com.season.winter.common.extention.view.glide

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
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

fun ImageView.setImageFromUrlOnResourceReadyCallback(
    imageUrl: String?,
    callback: (width: Int, height: Int) -> Unit
) {

    if (imageUrl.isNullOrEmpty())
        return

    Glide.with(context).load(imageUrl)
        .placeholder(ResourceModuleR.drawable.logo_icon_small)
        .into(this)
        .getSize { width, height ->
            callback(width, height)
//            val lp = layoutParams
//            lp.height = WRAP_CONTENT
//            layoutParams = lp
        }
}


fun ImageView.setImageFromUrlWrapHeight(imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    val target = object : CustomTarget<Bitmap>() {
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            Log.e("TAG", "onResourceReady: ${resource.height}", )
            layoutParams.apply {
                height = resource.height
            }
            setImageBitmap(resource)
        }
        override fun onLoadCleared(placeholder: Drawable?) {}
        override fun onLoadFailed(errorDrawable: Drawable?) {}
    }

    Glide.with(this)
        .asBitmap()
        .load(imageUrl)
        .into(target)

}