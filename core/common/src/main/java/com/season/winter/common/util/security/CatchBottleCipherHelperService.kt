package com.season.winter.common.util.security

import android.content.Context

interface CatchBottleCipherHelperService {
    fun init(context: Context)
    fun encrypt(plainText: String): String
    fun decrypt(base64EncryptedCipherText: String): String
}