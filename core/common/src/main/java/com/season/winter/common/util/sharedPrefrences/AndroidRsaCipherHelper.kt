package com.season.winter.common.util.sharedPrefrences

import android.content.Context
import android.util.Base64
import com.season.winter.common.util.security.RSA256
import java.security.KeyStore
import java.util.*
import javax.crypto.Cipher

object AndroidRsaCipherHelper {

    private var _isSupported = false
    private val isSupported: Boolean
        get() = _isSupported

    fun init(context: Context) {

        if (isSupported) return

        SecureSharedPreferences.init(context)

        val alias = "${context.packageName}.rsakeypairs"
        _isSupported = RSA256.create(alias)
    }

    //  암호화 길이 제한: 256바이트 이하 평문만 가능
    fun encrypt(plainText: String): String {
        if (!_isSupported)
            return plainText
        return RSA256.encrypt(plainText)
    }

    // 해독
    fun decrypt(base64EncryptedCipherText: String): String {
        if (!_isSupported)
            return base64EncryptedCipherText
        return RSA256.decrypt(base64EncryptedCipherText)
    }
}