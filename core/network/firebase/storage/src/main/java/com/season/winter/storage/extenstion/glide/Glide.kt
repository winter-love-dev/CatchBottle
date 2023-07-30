package com.season.winter.storage.extenstion.glide

import android.widget.ImageView
import com.season.winter.common.extention.view.glide.setImageFromUrl
import com.season.winter.storage.ImageFireStorageInstance

suspend fun ImageView.setImageFromFireStoreFileName(imageFileName: String?) {

    if (imageFileName.isNullOrEmpty())
        return

    val url =
        ImageFireStorageInstance
            .getImageUrlFromFileName(imageFileName)

    setImageFromUrl(url)
}
