package com.season.winter.common.extention.view.imageview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.season.winter.common.extention.view.glide.setImageFromUrl
import com.season.winter.common.extention.view.glide.setImageFromUrlWrapHeight

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    view.setImageFromUrl(imageUrl)
}



@BindingAdapter("imageFromUrlWrapHeight")
fun bindImageFromUrlWrapHeight(view: ImageView, imageUrl: String?) {

    if (imageUrl.isNullOrEmpty())
        return

    view.setImageFromUrlWrapHeight(imageUrl)
}

