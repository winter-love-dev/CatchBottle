package com.season.winter.common.util.sharedPrefrences.cipher

interface CipherService {
    fun create(alias: String): Boolean

    fun encrypt(plainText: String): String

    fun decrypt(base64EncryptedCipherText: String): String
}