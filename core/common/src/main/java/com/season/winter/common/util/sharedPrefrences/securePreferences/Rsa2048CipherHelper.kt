package com.season.winter.common.util.sharedPrefrences.securePreferences

import android.content.Context
import com.season.winter.common.util.security.CatchBottleCipherHelperService
import com.season.winter.common.util.security.Rsa2048Algorithm
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Rsa2048CipherHelper @Inject constructor(
    private val rsa2048: Rsa2048Algorithm
): CatchBottleCipherHelperService {

    private var isSupported = false

    override fun init(
        @ApplicationContext context: Context
    ) {

        if (isSupported) return

        val alias = "${context.packageName}.rsakeypairs"
        isSupported = rsa2048.create(alias)
    }

    override fun encrypt(plainText: String): String {
        if (!isSupported)
            return plainText
        return rsa2048.encrypt(plainText)
    }

    override fun decrypt(base64EncryptedCipherText: String): String {
        if (!isSupported)
            return base64EncryptedCipherText
        return rsa2048.decrypt(base64EncryptedCipherText)
    }
}