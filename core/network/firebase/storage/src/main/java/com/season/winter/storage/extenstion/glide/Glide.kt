package com.season.winter.storage.extenstion.glide

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.season.winter.common.extention.view.glide.setImageFromUrl
import com.season.winter.storage.ImageFireStorageInstance
import kotlinx.coroutines.launch

@BindingAdapter("imageFromFireStoreFileName")
fun bindImageFromFireStoreFileName(view: ImageView, imageFileName: String?) {

    if (imageFileName.isNullOrEmpty())
        return

    view.findViewTreeLifecycleOwner()?.let {
        it.lifecycleScope.launch {
            val url =
                ImageFireStorageInstance
                    .getImageUrlFromFileName(imageFileName)

            view.setImageFromUrl(url)
        }
    }
}
