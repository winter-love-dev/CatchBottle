package com.season.winter.common.util.sharedPrefrences.cipher

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Rsa2048CipherHelper @Inject constructor(
    @ApplicationContext context: Context,
    private val rsa2048: Rsa2048AlgorithmImpl
): CatchBottleCipherHelperService {

    private var isSupported = false

    init {
        val alias = "${context.packageName}.rsakeypairs"
        isSupported = rsa2048.create(alias)
    }

    override fun encrypt(plainText: String): String {
        return if (isSupported.not())
            plainText
        else
            rsa2048.encrypt(plainText)
    }

    override fun decrypt(base64EncryptedCipherText: String): String {
        return if (isSupported.not())
            base64EncryptedCipherText
        else
            rsa2048.decrypt(base64EncryptedCipherText)
    }
}