package com.season.winter.storage.extenstion.glide

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.season.winter.common.extention.view.glide.setImageFromUrl
import com.season.winter.storage.ImageFireStorageInstance
import kotlinx.coroutines.launch

@BindingAdapter("imageFromFireStoreFileName")
fun bindImageFromFireStoreFileName(view: ImageView, imageFileName: String?) {

    if (imageFileName.isNullOrEmpty())
        return

    view.findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
        lifecycleOwner.lifecycleScope.launch {
            val url =
                ImageFireStorageInstance
                    .getImageUrlFromFileName(imageFileName)

            view.setImageFromUrl(url)
        }
    }
}


fun ImageView.preloadImageFromFireStoreFileName(imageFileName: String?) {

    if (imageFileName.isNullOrEmpty())
        return

    findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
        lifecycleOwner.lifecycleScope.launch {
            val url =
                ImageFireStorageInstance
                    .getImageUrlFromFileName(imageFileName) ?: return@launch

            Glide.with(context).load(url).preload()
        }
    }
}
