package com.season.winter.common.util.security

interface CatchBottleCipherHelperService {

    fun encrypt(plainText: String): String
    fun decrypt(base64EncryptedCipherText: String): String
}