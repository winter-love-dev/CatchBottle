package com.season.winter.storage

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await
import java.lang.Exception

object ImageFireStorageInstance {

    private const val TAG = "ImageFireStorageInstance"

    private const val imagesPath = "images/"

    private val storageRef = Firebase.storage.reference

    suspend fun getImageUrlFromFileName(fileName: String): String? {
        return try {
            val path = "$imagesPath$fileName"
            val imageUrl = storageRef.child(path).downloadUrl.await()
            imageUrl.toString()
        } catch (e: Exception) {
            Log.e(TAG, "suspendTest: e: $e", )
            null
        }
    }
}