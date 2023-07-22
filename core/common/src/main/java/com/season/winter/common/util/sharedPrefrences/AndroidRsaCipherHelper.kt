package com.season.winter.common.util.sharedPrefrences

import android.content.Context
import com.season.winter.common.util.security.RSA2048

object AndroidRsaCipherHelper {

    private var isSupported = false
//    private val isSupported: Boolean
//        get() = _isSupported

    fun init(context: Context) {

        if (isSupported) return

        val alias = "${context.packageName}.rsakeypairs"
        isSupported = RSA2048.create(alias)
    }

    //  암호화 길이 제한: 256바이트 이하 평문만 가능
    fun encrypt(plainText: String): String {
        if (!isSupported)
            return plainText
        return RSA2048.encrypt(plainText)
    }

    // 해독
    fun decrypt(base64EncryptedCipherText: String): String {
        if (!isSupported)
            return base64EncryptedCipherText
        return RSA2048.decrypt(base64EncryptedCipherText)
    }
}