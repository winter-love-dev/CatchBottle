package com.season.winter.common.util.sharedPrefrences.securePreferences

import android.content.Context
import com.season.winter.common.util.security.RSA2048

object AndroidRsaCipherHelper {

    private var isSupported = false

    fun init(context: Context) {

        if (isSupported) return

        val alias = "${context.packageName}.rsakeypairs"
        isSupported = RSA2048.create(alias)
    }

    fun encrypt(plainText: String): String {
        if (!isSupported)
            return plainText
        return RSA2048.encrypt(plainText)
    }

    fun decrypt(base64EncryptedCipherText: String): String {
        if (!isSupported)
            return base64EncryptedCipherText
        return RSA2048.decrypt(base64EncryptedCipherText)
    }
}