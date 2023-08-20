package com.season.winter.storage.extenstion.glide

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.season.winter.common.extention.view.glide.setImageFromUrl
import com.season.winter.common.extention.view.glide.setImageFromUrlWrapHeight
import com.season.winter.storage.ImageFireStorage
import kotlinx.coroutines.launch

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


//fun ImageView.preloadImageFromFireStoreFileName(imageFileName: String?) {
//
//    if (imageFileName.isNullOrEmpty())
//        return
//
//    findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
//        lifecycleOwner.lifecycleScope.launch {
//            val url =
//                ImageFireStorage.getImageUrlFromFileName(imageFileName) ?: return@launch
//
//            Glide.with(context).load(url).preload()
//        }
//    }
//}
